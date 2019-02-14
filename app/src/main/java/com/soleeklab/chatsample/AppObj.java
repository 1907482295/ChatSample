package com.soleeklab.chatsample;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import co.chatsdk.core.error.ChatSDKException;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.core.session.Configuration;
import co.chatsdk.firebase.FirebaseModule;
import co.chatsdk.firebase.FirebaseNetworkAdapter;
import co.chatsdk.firebase.file_storage.FirebaseFileStorageModule;
import co.chatsdk.firebase.push.FirebasePushModule;
import co.chatsdk.profile.pictures.ProfilePicturesModule;
import co.chatsdk.ui.manager.UserInterfaceModule;

/**
 * Created by itzik on 6/8/2014.
 */
public class AppObj extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        Context context = getApplicationContext();

        Configuration.Builder builder = new Configuration.Builder(context);
        builder.firebaseRootPath("test");

        // Initialize the Chat SDK
        try {
            ChatSDK.initialize(builder.build(), new FirebaseNetworkAdapter(), new MyAppInterfaceAdaper(context));
            ChatSDK.shared().setInterfaceAdapter(new MyAppInterfaceAdaper(context));

        } catch (ChatSDKException e) {
            e.printStackTrace();
        }

        UserInterfaceModule.activate(context);
        FirebaseModule.activate();
        FirebaseFileStorageModule.activate();


// File storage is needed for profile image upload and image messages
        FirebaseFileStorageModule.activate();
        FirebasePushModule.activate();

        ProfilePicturesModule.activate();

    }
    @Override
    protected void attachBaseContext (Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
