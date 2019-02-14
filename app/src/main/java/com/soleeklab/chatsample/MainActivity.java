package com.soleeklab.chatsample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.core.types.AccountDetails;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ChatSDK.auth().authenticateWithCachedToken()
//                .observeOn(AndroidSchedulers.mainThread())
//                .doFinally(() -> {
//
//                })
//                .subscribe(this::afterLogin, throwable -> {
//                        ChatSDK.logError(throwable);
//
//                });
        //InterfaceManager.shared().a.startLoginActivity(getApplicationContext(),true);
      //  ChatSDK.ui().startLoginActivity(getApplicationContext(),true);
        AccountDetails details = AccountDetails.username("shirt@soleeklab.com", "00000000");
        ChatSDK.auth().authenticate(details)
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> {

                })
                .subscribe(this::afterLogin, e -> {
                    ChatSDK.logError(e);
                });
        //ChatSDK.ui().startLoginActivity(getApplicationContext(),true);
       // ChatSDK.ui().startMainActivity(this);


        // ChatSDK.ui().startLoginActivity(getApplicationContext(),true);
    }
    /* Dismiss dialog and open main context.*/
    protected void afterLogin() {

//        List<Thread> threads = ChatSDK.thread().getThreads(ThreadType.Private);
//        ChatSDK.ui().startChatActivityForID(getBaseContext(), threads.get(0).getEntityID());
//        System.out.println("shirt"+threads.get(0).lastMessage().getText());
        ChatSDK.ui().startProfileActivity(getApplicationContext(),ChatSDK.currentUser().getEntityID());

    }
}
