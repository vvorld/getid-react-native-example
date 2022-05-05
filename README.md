# getid-react-native-example
This repository contains an example of integration native GetID [iOS](https://github.com/vvorld/getid-ios-sdk) and [Android](https://github.com/vvorld/getid-android-sdk) SDKs into a React Native cross-platform application.

## Setup
In order to start using GetID SDK, you will need an `SDK KEY` and `API URL`. Both can be found and modified either through your GetID admin panel or via contacting our [integration team](mailto:support@getid.ee).

Also, make sure that you've set up the [development environment](https://reactnative.dev/docs/environment-setup).

## How to run this project
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

## How to install GetID SDK from scratch
**iOS**
1. Add `pod 'GetID', '2.6.0'` to `ios/Podfile`. The number of the latest version of GetID iOS SDK can be found [here](https://github.com/vvorld/getid-ios-sdk/releases).
2. In `ios` folder run `pod install`.
3. Add `NSPhotoLibraryUsageDescription`, `NSMicrophoneUsageDescription` and `NSCameraUsageDescription` to `ios/YourProjectName/Info.plist`. See description examples in this repository.
4. Open the `.xcworkspace` file in Xcode. Select `File > New > File > Swift File`, name it `GetIDSwiftWrapper`. When Xcode asks whether you want to add a bridging header file, confirm that you want to create it.
5. Select `File > New > File > Cocoa Touch Class`, subclass of `NSObject`, language `Objective-C`, name it `RCTGetID`.
6. Copy content of `RCTGetID.h`, `RCTGetID.m` and `GetIDSwiftWrapper.swift` from this repository to newly created files. Rename an import in `RCTGetID.m` to `#import "YourProjectName-Swift.h"`.

**Android**
1. Add `jcenter()` to `allprojects.repositories` in `build.gradle` before `mavenCentral()`.
2. Add `implementation 'ee.getid:getidlib:2.6.3'` to `android/app/build.gradle`. The number of the latest version of GetID Android SDK can be found [here](https://github.com/vvorld/getid-android-sdk/releases).
3. Add `implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'` to `android/app/build.gradle`.
4. Copy `GetID.java` file from this repository to `android/app/src/main/java/com/yourprojectname`.
5. Copy `MyAppPackage.java` file from this repository to `android/app/src/main/java/com/yourprojectname`.
6. Add `packages.add(new MyAppPackage());` in `MainApplication.java`. See the exact place in this repository.
7. Remove `android:allowBackup="false"` from `AndroidManifest.xml`.
8. Copy the GetID activity to `AndroidManifest.xml` from this repository.

**Common**

In a `.js` file, in the place you want to start the GetID verification flow, you have to call `GetID.start(apiUrl, token, flowName);`. For example, see `App.js` file in this repository.