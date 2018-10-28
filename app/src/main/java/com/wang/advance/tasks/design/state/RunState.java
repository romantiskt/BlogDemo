package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class RunState extends LifeState {
    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void stop() {
        super.context.setState(Context.stopState);
        super.context.stop();
    }

    @Override
    public void run() {
        System.out.println("正在运行");
    }
}
