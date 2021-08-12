import GetID

@objc final class GetIDSwiftWrapper: NSObject {
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
    NSLog("verificationFlowDidStart")
  }

  func verificationFlowDidCancel() {
    NSLog("verificationFlowDidCancel")
  }

  func verificationFlowDidFail(_ error: GetIDError) {
    NSLog("verificationFlowDidFail: \(error)")
  }

  func verificationFlowDidComplete(_ application: GetIDApplication) {
    NSLog("verificationFlowDidComplete: \(application.applicationId)")
  }
}
