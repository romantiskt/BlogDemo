package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class OpenState extends LifeState {
    @Override
    public void open() {
        System.out.println("已开启");
    }

    @Override
    public void close() {
        super.context.setState(Context.closeState);
        super.context.close();
    }

    @Override
    public void stop() {

    }

    @Override
    public void run() {

    }
}
