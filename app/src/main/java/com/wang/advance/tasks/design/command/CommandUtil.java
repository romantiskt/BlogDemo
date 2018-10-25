package com.wang.advance.tasks.design.command;

/**
 * Created by romantiskt on 2018/10/25.
 * 这个命令模式有点不明觉厉
 */

public class CommandUtil {

    public static void test(){
        Invoker invoker=new Invoker();
        invoker.setCommand(new Thread1Command(new Thread1Receiver()));
        invoker.action();
    }
}
