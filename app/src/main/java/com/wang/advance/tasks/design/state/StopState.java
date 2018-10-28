package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class StopState extends LifeState {
    @Override
    public void open() {
        super.context.setState(Context.openState);
        super.context.open();
    }

    @Override
    public void close() {

    }

    @Override
    public void stop() {
        System.out.println("已停止");
    }

    @Override
    public void run() {
        super.context.setState(Context.runState);
        super.context.run();
    }
}
