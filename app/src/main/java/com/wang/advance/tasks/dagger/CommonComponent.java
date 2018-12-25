package com.wang.advance.tasks.dagger;


import dagger.Component;

@Component(modules = CommonModule.class)
public interface CommonComponent {

    void inject(DraggerDemoAct draggerDemoAct);
}
