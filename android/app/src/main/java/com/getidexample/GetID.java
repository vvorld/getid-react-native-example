package com.getidexample;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.sdk.getidlib.app.common.receivers.BroadcastReceiverListener;
import com.sdk.getidlib.config.GetIDSDK;
import com.sdk.getidlib.model.app.auth.Token;
import com.sdk.getidlib.model.entity.events.GetIDApplication;
import com.sdk.getidlib.model.entity.events.GetIDError;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GetID extends ReactContextBaseJavaModule {

    ReactApplicationContext appContext;

    GetID(ReactApplicationContext context) {
        super(context);
        appContext = context;
    }

    @Override
    public String getName() {
        return "GetID";
    }

    @ReactMethod
    public void addListener(String eventName) {
    }

    @ReactMethod
    public void removeListeners(Integer count) {
    }

    @ReactMethod
    public void start(String url, String token, String flowName) {
        new GetIDSDK().startVerificationFlow(
                appContext,
                url,
                new Token(token),
                flowName,
                null,
                null,
                null,
                new GetIDEventListener(appContext)
        );
    }
}

class GetIDEventListener implements BroadcastReceiverListener {

    private ReactApplicationContext appContext;

    GetIDEventListener(ReactApplicationContext context) {
        appContext = context;
    }

    @Override
    public void verificationFlowCancel() {
        sendEvent("verificationFlowDidCancel", null, null);
    }

    @Override
    public void verificationFlowComplete(@NotNull GetIDApplication getIDApplication) {
        sendEvent("verificationFlowDidComplete", "applicationId", getIDApplication.getApplicationId());
    }

    @Override
    public void verificationFlowFail(@NotNull GetIDError getIDError) {
        sendEvent("verificationFlowDidFail", "error", getIDError.name());
    }

    @Override
    public void verificationFlowStart() {
        sendEvent("verificationFlowDidStart", null, null);
    }

    private void sendEvent(String eventType, @Nullable String additionalKey, @Nullable String additionalValue) {
        WritableMap arguments = Arguments.createMap();
        arguments.putString("eventType", eventType);
        if (additionalKey != null && additionalValue != null) {
            arguments.putString(additionalKey, additionalValue);
        }
        appContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("GetIDEvent", arguments);
    }
}