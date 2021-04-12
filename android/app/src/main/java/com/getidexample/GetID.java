package com.getidexample;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.sdk.getidlib.config.GetIDSDK;
import com.sdk.getidlib.model.app.auth.Token;
import com.sdk.getidlib.model.app.metadata.Metadata;
import java.util.Map;

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
    public void start(String url, String token, String flowName, ReadableMap metadataLabels) {
        Map<String, String> labels = (Map) metadataLabels.toHashMap();
        new GetIDSDK().startVerificationFlow(
                appContext,
                url,
                new Token(token),
                flowName,
                new Metadata(null, labels),
                null,
                null,
                null
        );
    }
}
