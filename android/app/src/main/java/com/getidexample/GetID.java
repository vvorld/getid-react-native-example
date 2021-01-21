package com.getidexample;
import android.content.res.Configuration;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.sdk.getidlib.config.ConfigurationPreset;
import com.sdk.getidlib.config.FlowScreens;
import com.sdk.getidlib.config.GetIDFactory;
import com.sdk.getidlib.config.VerificationTypesEnum;
import com.sdk.getidlib.model.app.document.CountryDocumentConfig;
import com.sdk.getidlib.model.app.form.FormConfig;
import com.sdk.getidlib.model.app.form.FormField;
import com.sdk.getidlib.model.app.liveness.LivenessConfig;
import com.sdk.getidlib.model.app.selfie.SelfieConfig;
import com.sdk.getidlib.model.app.thank_you.ThankYouConfig;
import com.sdk.getidlib.model.app.video_recording.VideoRecordingConfig;
import com.sdk.getidlib.config.DesignColorSchema;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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
    public void start(String token, String url) {
        List<FlowScreens> flowItems = new ArrayList<>();
        flowItems.add(FlowScreens.SCREEN_CONSENT);
        flowItems.add(FlowScreens.SCREEN_DOCUMENT);
        flowItems.add(FlowScreens.SCREEN_SELFIE);
        flowItems.add(FlowScreens.SCREEN_LIVENESS);
        ArrayList<VerificationTypesEnum> verificationTypes = new ArrayList<>();
        verificationTypes.add(VerificationTypesEnum.FACE_MATCHING);
        verificationTypes.add(VerificationTypesEnum.DATA_EXTRACTION);
        DesignColorSchema designColorSchema = new DesignColorSchema(null, null, null,
                null, "#0E1C2C", null, "#FFFFFF", false);
        ConfigurationPreset configPreset = new ConfigurationPreset(
                flowItems,
                null,
                null,
                null,
                null,
                null,
                verificationTypes,
                null,
                designColorSchema);
        List<Locale> locale = new ArrayList<>();
        locale.add(Locale.ENGLISH);
        new GetIDFactory().setup(appContext, configPreset, token,
                url, locale, null);
    }
}

