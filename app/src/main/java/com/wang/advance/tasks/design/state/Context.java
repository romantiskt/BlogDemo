package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 */

public class Context {
    public final static OpenState openState = new OpenState();
    public final static CloseState closeState = new CloseState();
    public final static StopState stopState = new StopState();
    public final static RunState runState = new RunState();

    public LifeState state;

    public LifeState getState() {
        return state;
    }

    public void setState(LifeState state) {
        this.state = state;
    }

    public void open() {
        this.state.open();
    }

    public void close() {
        this.state.close();
    }

    public void run() {
        this.state.run();
    }

    public void stop() {
        this.state.stop();
    }
}
