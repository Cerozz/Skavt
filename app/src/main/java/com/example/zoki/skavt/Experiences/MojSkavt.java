package com.example.zoki.skavt.Experiences;

import android.app.Application;

public class MojSkavt  extends Application {
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
