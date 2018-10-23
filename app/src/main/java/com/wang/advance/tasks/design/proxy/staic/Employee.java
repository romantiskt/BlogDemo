package com.wang.advance.tasks.design.proxy.staic;

/**
 * Created by wangyang on 2018/10/23.上午10:39
 * 代理模式
 */
public class Employee extends AbstractPerson {

    AbstractPerson person;

    public Employee(AbstractPerson person) {
        this.person = person;
    }

    @Override
    protected void doWork() {
        this.writePlan();
        this.person.doWork();
        this.reportResult();
    }

    private void writePlan(){
        System.out.println("书写计划。。。");
    }


    private void reportResult(){
        System.out.println("将结果报告给老板。。。。");
    }
}
