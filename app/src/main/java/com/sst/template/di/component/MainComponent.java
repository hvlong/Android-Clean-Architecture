package com.sst.template.di.component;

import com.sst.template.di.module.AppModule;
import com.sst.template.service.NetworkModule;
import com.sst.template.ui.home.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author LongHV.
 */
@Singleton
@Component(modules = {NetworkModule.class, AppModule.class})
public interface MainComponent {

    void inject(HomeActivity homeActivity);
}
