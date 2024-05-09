package com.example.motoclient.di;


import com.example.motoclient.DiActivity;

import javax.inject.Singleton;

import dagger.Component;

//MIDDLEMAN
@Singleton
@Component(modules = SharedPrefModule.class)  //middle man
public interface MyComponent {

    void inject(DiActivity activity);

}
