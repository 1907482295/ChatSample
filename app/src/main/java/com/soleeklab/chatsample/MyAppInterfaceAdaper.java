package com.soleeklab.chatsample;

import android.content.Context;

import co.chatsdk.ui.manager.BaseInterfaceAdapter;

public class MyAppInterfaceAdaper extends BaseInterfaceAdapter {
    public MyAppInterfaceAdaper(Context context) {
        super(context);
    }

    @Override
    public Class getProfileActivity() {
        return MyAppProfileActivity.class;
    }
}
