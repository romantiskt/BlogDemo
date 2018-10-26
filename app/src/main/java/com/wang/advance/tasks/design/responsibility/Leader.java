package com.wang.advance.tasks.design.responsibility;

/**
 * Created by wangyang on 2018/10/26.下午5:19
 */
public abstract class Leader {
    /**
     * 当前能批复的假期
     */
    protected int applyDays;

    /**
     * 上一级领导
     */
    protected Leader supperLeader;

    public Leader(int applyDays) {
        this.applyDays = applyDays;
    }

    protected abstract void replay();


    protected void handleRequest(Developer developer){

        if(developer.getVacationDays()<=applyDays){
            replay();
        }else {
            if(null==supperLeader){
                System.out.println("您的请求没人可以同意你啦");
            }else {
                supperLeader.handleRequest(developer);
            }
        }

    }

    protected void setLeader(Leader leader){
        this.supperLeader=leader;
    }

}
