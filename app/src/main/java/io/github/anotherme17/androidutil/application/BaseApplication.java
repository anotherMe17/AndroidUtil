package io.github.anotherme17.androidutil.application;

import android.app.Application;

import io.github.anotherme17.android_util.Utils;

/**
 * @author AnotherMe17
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
