package com.sst.template;

import android.app.Application;

import com.sst.template.di.component.DaggerMainComponent;
import com.sst.template.di.module.AppModule;
import com.sst.template.di.component.MainComponent;
import com.sst.template.di.module.NetworkModule;

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
                .networkModule(new NetworkModule(BuildConfig.BASE_URL)).build();
    }

    public MainComponent getNetWorkComponent() {
        return mainComponent;
    }

}
