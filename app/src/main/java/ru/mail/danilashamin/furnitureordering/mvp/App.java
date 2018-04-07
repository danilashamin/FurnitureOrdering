package ru.mail.danilashamin.furnitureordering.mvp;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }

    public static Context getContext() {
        return instance;
    }
}
