package com.wang.tools.common;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * Activity任务栈
 */
public class ActivityTasks {

    private static List<Activity> activityTasks = new ArrayList<>();

    public static void addActivity(Activity activity) {
        if (!activityTasks.contains(activity))
            activityTasks.add(activity);
    }

    public static void removeActivity(Activity activity) {
        if (activityTasks.contains(activity))
            activityTasks.remove(activity);
    }

    public static Activity getTopActivity() {
        try {
            return activityTasks.get(activityTasks.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public static List<Activity> getActivityTasks() {
        return activityTasks;
    }

    public static void finishAllActivity() {
        for (Activity activity : activityTasks) {
            activity.finish();
        }
    }

    /**
     * 去到登录页面时,需要实时刷新页面且强制要求登录的页面需要强制finish
     * <p>
     * 否则会出现点击返回后死循环，一直进入LoginActivity的bug
     */
    public static boolean finishAllNeedLoginActivities() {

        boolean postRefreshEvent = false;
        // 循环一定要跑完
        for (Activity activity : activityTasks) {
//            if (activity instanceof EnterAct_
//                    ) {
//            } else {
//                activity.finish();
//                postRefreshEvent = true;
//            }
        }

        return postRefreshEvent;
    }
}
