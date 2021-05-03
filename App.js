import React from 'react';
import { NativeModules, Button, View } from 'react-native';

const { GetID } = NativeModules;

const VerifyButton = () => {

  // Note: Don't use your SDK key in the client-side code in the production environment.
  const apiUrl = 'API_URL';
  const sdkKey = 'SDK_KEY';
  const flowName = "getid-doc-selfie";
  const externalId = 'some-id';

  const getToken = () => {
    return fetch(apiUrl + '/sdk/v2/token', {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        'x-sdk-key': sdkKey
      }
    });
  };

  const onPress = () => {
    getToken()
    .then((response) => response.json())
    .then((json) => {
      GetID.start(apiUrl, json.token, flowName, externalId);
    });
  };

  return (
    <View style={[{ marginLeft: 20, marginTop: 100, marginRight: 20, backgroundColor: "white" }]}>
      <Button
        title="Verify me!"
        color="blue"
        onPress={onPress}
      />
    </View>
  );
};

export default VerifyButton;