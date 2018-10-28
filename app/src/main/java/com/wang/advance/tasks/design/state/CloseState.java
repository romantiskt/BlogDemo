package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class CloseState extends LifeState {
    @Override
    public void open() {
       super.context.setState(Context.openState);
       super.context.open();
    }

    @Override
    public void close() {
        System.out.println("已关闭");
    }

    @Override
    public void stop() {
        super.context.setState(Context.stopState);
        super.context.stop();
    }

    @Override
    public void run() {
        super.context.setState(Context.runState);
        super.context.run();
    }
}
