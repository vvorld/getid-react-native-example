package com.getidexample;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.sdk.getidlib.config.GetIDSDK;
import com.sdk.getidlib.model.app.auth.Token;

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
                null
        );
    }
}
