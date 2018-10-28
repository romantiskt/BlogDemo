package com.wang.advance.tasks.design.state;

/**
 * Created by romantiskt on 2018/10/28.
 * 状态模式   这里的例子是对状态间切换有限制时的例子
 */

public class StateTest {

    public static void test(){
        Context context=new Context();
        context.setState(new CloseState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
