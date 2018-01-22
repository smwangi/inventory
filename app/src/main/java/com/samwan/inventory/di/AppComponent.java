package com.samwan.inventory.di;

import android.app.Application;
import android.arch.lifecycle.ViewModel;

import com.samwan.inventory.InvApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by smwangi on 1/17/18.
 */
@Singleton
@Component(modules = {
        //AppModule.class,
        AndroidInjectionModule.class,
        ViewModelModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(InvApp aaApp);
}
