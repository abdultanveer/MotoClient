package com.example.motoclient.di;


import com.example.motoclient.DiActivity;

import dagger.Component;

@Component(modules = SharedPrefModule.class)  //middle man
public interface MyComponent {

    void inject(DiActivity activity);

}
