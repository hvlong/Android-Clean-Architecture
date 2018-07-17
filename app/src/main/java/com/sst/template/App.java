package com.sst.template;

import android.app.Application;

import com.sst.template.di.component.DaggerMainComponent;
import com.sst.template.di.module.AppModule;
import com.sst.template.di.component.MainComponent;
import com.sst.template.service.NetworkModule;

/**
 * @author LongHV.
 */
public class App extends Application {

    MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mainComponent = DaggerMainComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(BuildConfig.BASEURL)).build();
    }

    public MainComponent getNetWorkComponent() {
        return mainComponent;
    }
}