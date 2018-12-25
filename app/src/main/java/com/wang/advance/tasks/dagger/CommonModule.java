package com.wang.advance.tasks.dagger;


import dagger.Module;

@Module
public class CommonModule {
    DraggerDemoAct draggerDemoAct;

    public CommonModule(DraggerDemoAct draggerDemoAct) {
        this.draggerDemoAct = draggerDemoAct;
    }
}
