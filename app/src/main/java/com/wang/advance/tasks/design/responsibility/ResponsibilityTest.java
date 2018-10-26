package com.wang.advance.tasks.design.responsibility;

/**
 * Created by wangyang on 2018/10/26.下午5:38
 *
 * 责任链模式
 *
 */
public class ResponsibilityTest {

    public static void test(){

        Developer developer=new AndroidDeveloper();
        developer.apply(12000);

        Leader androidLeader=new AndroidLeader();
        Leader clientLeader=new ClientLeader();
        Leader bossLeader=new BossLeader();

        androidLeader.setLeader(clientLeader);
        clientLeader.setLeader(bossLeader);

        androidLeader.handleRequest(developer);


    }
}
