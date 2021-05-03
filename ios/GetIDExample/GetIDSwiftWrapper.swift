import GetID

@objc final class GetIDSwiftWrapper: NSObject {
  @objc func startVerificationFlow(apiUrl: String, token: String, flowName: String, externalId: String) {
    GetIDSDK.startVerificationFlow(
      apiUrl: apiUrl,
      auth: .jwt(token),
      flowName: flowName,
      metadata: .init(externalId: externalId)
    )
  }
}
