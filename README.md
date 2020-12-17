# getid-react-native-example
This repository contains an example of integration native GetID [iOS](https://github.com/vvorld/getid-ios-sdk) and [Android](https://github.com/vvorld/getid-android-sdk) SDKs into a React Native cross-platform application.

## Setup
In order to start using GetID SDK, you will need an `SDK KEY` and `API URL`. Both can be found and modified either through your GetID admin panel or via contacting our [integration team](mailto:support@getid.ee).

Also, make sure that you've set up the [development environment](https://reactnative.dev/docs/environment-setup).

Clone the project, navigate to the project directory and install node modules:
```bash
git clone https://github.com/vvorld/getid-react-native-example
cd getid-react-native-example
npm install
```

Open `App.js` file and set `apiUrl` and `sdkKey`.

### iOS
```bash
cd ios
pod install
```
Then open `ios/GetIDExample.workspace` in Xcode and run the app or just type `npx react-native run-ios` in the root project directory.

### Android
Open `android` in Android Studio and run the app or `npx react-native start` in one Terminal window and `npx react-native run-android` in another.
