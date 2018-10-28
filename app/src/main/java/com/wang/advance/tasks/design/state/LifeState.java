package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 */

public abstract class LifeState {
    protected Context context;

    /**
     * 打开门
     */
    public abstract void open();

    /**
     * 关闭门
     */
    public abstract void close();

    /**
     * 停止
     */
    public abstract void stop();

    /**
     * 运行
     */
    public abstract void run();
}
