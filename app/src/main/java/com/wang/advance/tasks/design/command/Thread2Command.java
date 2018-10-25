package com.wang.advance.tasks.design.command;

/**
 * Created by romantiskt on 2018/10/25.
 */

public class Thread2Command extends Command {
    Receiver receiver;

    public Thread2Command(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.doSomething();
    }
}
