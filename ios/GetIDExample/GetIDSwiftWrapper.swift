import GetID

@objc protocol GetIDSwiftWrapperDelegate: AnyObject {
  func sendGetIDEvent(body: [String: String])
}

@objc final class GetIDSwiftWrapper: NSObject {
  @objc weak var delegate: GetIDSwiftWrapperDelegate?

  @objc func startVerificationFlow(apiUrl: String, token: String, flowName: String) {
    GetIDSDK.delegate = self
    GetIDSDK.startVerificationFlow(
      apiUrl: apiUrl,
      auth: .jwt(token),
      flowName: flowName
    )
  }
}

extension GetIDSwiftWrapper: GetIDSDKDelegate {
  func verificationFlowDidStart() {
    delegate?.sendGetIDEvent(body: ["eventType": "verificationFlowDidStart"])
  }

  func verificationFlowDidCancel() {
    delegate?.sendGetIDEvent(body: ["eventType": "verificationFlowDidCancel"])
  }

  func verificationFlowDidFail(_ error: GetIDError) {
    delegate?.sendGetIDEvent(body: ["eventType": "verificationFlowDidFail", "error": "\(error)"])
  }

  func verificationFlowDidComplete(_ application: GetIDApplication) {
    delegate?.sendGetIDEvent(body: ["eventType": "verificationFlowDidComplete", "applicationId": "\(application.applicationId)"])
  }
}
