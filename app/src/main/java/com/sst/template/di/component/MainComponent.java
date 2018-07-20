package com.sst.template.di.component;

import com.sst.template.di.module.AppModule;
import com.sst.template.di.module.NetworkModule;
import com.sst.template.view.activity.detail.DetailActivity;
import com.sst.template.view.activity.home.HomeActivity;
import com.sst.template.view.fragment.detail.DetailFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author LongHV.
 */
@Singleton
@Component(modules = {NetworkModule.class, AppModule.class})
public interface MainComponent {

    void inject(HomeActivity homeActivity);
    void inject(DetailActivity detailActivity);
    void inject(DetailFragment detailFragment);
}
