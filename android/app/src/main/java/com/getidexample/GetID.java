package com.getidexample;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.sdk.getidlib.app.common.receivers.BroadcastReceiverListener;
import com.sdk.getidlib.config.GetIDSDK;
import com.sdk.getidlib.model.app.auth.Token;
import com.sdk.getidlib.model.entity.events.GetIDApplication;
import com.sdk.getidlib.model.entity.events.GetIDError;

import org.jetbrains.annotations.NotNull;

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
    public void start(String url, String token, String flowName) {
        new GetIDSDK().startVerificationFlow(
                appContext,
                url,
                new Token(token),
                flowName,
                null,
                null,
                null,
                new GetIDEventListener()
        );
    }
}

class GetIDEventListener implements BroadcastReceiverListener {

    private static final String TAG = "GetIDEventListener";

    @Override
    public void verificationFlowCancel() {
        Log.d(TAG, "verificationFlowCancel:");
    }

    @Override
    public void verificationFlowComplete(@NotNull GetIDApplication getIDApplication) {
        Log.d(TAG, String.format("verificationFlowComplete: %s", getIDApplication.getApplicationId()));
    }

    @Override
    public void verificationFlowFail(@NotNull GetIDError getIDError) {
        Log.d(TAG, String.format("verificationFlowFail: %s", getIDError.name()));
    }

    @Override
    public void verificationFlowStart() {
        Log.d(TAG, "verificationFlowStart:");
    }
}