package com.wang.advance.tasks.design.command;

/**
 * Created by romantiskt on 2018/10/25.
 */

public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action(){
        this.command.execute();
    }
}
