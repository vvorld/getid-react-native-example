import GetID

@objc final class GetIDSwiftWrapper: NSObject {
  @objc func startVerificationFlow(apiUrl: String, token: String, flowName: String, metadataLabels: [String: String]) {
    GetIDSDK.startVerificationFlow(
      apiUrl: apiUrl,
      auth: .jwt(token),
      flowName: flowName,
      metadata: .init(labels: metadataLabels)
    )
  }
}
