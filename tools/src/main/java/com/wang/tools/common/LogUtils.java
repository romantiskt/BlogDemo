/*
 * LogUtils.java
 * business
 * Created by wangyang on 2017/1/3.
 *
 * Copyright (c) 2017年 zaicent. All rights reserved.
 */

package com.wang.tools.common;

import android.text.TextUtils;
import android.util.Log;

import java.util.List;

public class LogUtils {
    /**
     * 日志输出级别NONE
     */
    public static final int LEVEL_NONE = 0;
    /**
     * 日志输出级别V
     */
    public static final int LEVEL_VERBOSE = 1;
    /**
     * 日志输出级别D
     */
    public static final int LEVEL_DEBUG = 2;
    /**
     * 日志输出级别I
     */
    public static final int LEVEL_INFO = 3;
    /**
     * 日志输出级别W
     */
    public static final int LEVEL_WARN = 4;
    /**
     * 日志输出级别E
     */
    public static final int LEVEL_ERROR = 5;

    /**
     * 日志输出时的TAG
     */
    private static String mTag = "home";
    private static String mNetTag = "woopra";
    /**
     * 是否允许输出log
     */
    private static int mDebuggable = 7;

    /**
     * 用于记时的变量
     */
    private static long mTimestamp = 0;
    /**
     * 写文件的锁对象
     */
    private static final Object mLogLock = new Object();

    /**
     * 初始化网络tag和普通tag,是否输出日志,
     *
     * @param tag
     * @param netTag
     */
    public static void init(String tag, String netTag) {
        init(tag, netTag, true);
    }

    public static void init(String commonTag) {
        init(commonTag, null);
    }

    /**
     *
     * @param tag 普通输出标志
     * @param netTag 网络日志输出标志
     * @param isDebug  是否开启debug模式
     */
    public static void init(String tag, String netTag, boolean isDebug) {
        if (!TextUtils.isEmpty(tag))
            mTag = tag;
        if (!TextUtils.isEmpty(netTag))
            mNetTag = tag;
        mDebuggable = isDebug ? Integer.MAX_VALUE : 0;
    }

    /**
     * 输出网络日志
     */
    public static void n(String msg) {
        if (mDebuggable >= LEVEL_DEBUG) {
            if (!TextUtils.isEmpty(msg)) {
                if (msg.length() > 4000) {
                    //                    Log.v(TAG, "sb.length = " + responseInfo.result.length());
                    int chunkCount = msg.length() / 4000;     // integer division
                    for (int i = 0; i <= chunkCount; i++) {
                        int max = 4000 * (i + 1);
                        if (max >= msg.length()) {
                            Log.v(mNetTag, "chunk " + i + " of " + chunkCount + ":" + msg.substring(4000 * i));
                        } else {
                            Log.v(mNetTag, "chunk " + i + " of " + chunkCount + ":" + msg.substring(4000 * i, max));
                        }
                    }
                } else {
                    Log.v(mNetTag, msg.toString());
                }
            }
        }
    }

    /**
     * 输出IM日志
     */
    public static void m(String msg) {
        if (mDebuggable >= LEVEL_DEBUG) {
            Log.d("chat", msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void v(String msg) {
        if (mDebuggable >= LEVEL_VERBOSE) {
            Log.v(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(String msg) {
        if (mDebuggable >= LEVEL_DEBUG) {
            if (!TextUtils.isEmpty(msg))
                Log.d(mTag, msg);
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void rong(String msg) {
        if (mDebuggable >= LEVEL_DEBUG) {
            if (!TextUtils.isEmpty(msg))
                Log.d("rongtag", msg);
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(String msg) {
        if (mDebuggable >= LEVEL_INFO) {
            Log.i(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(String msg) {
        if (mDebuggable >= LEVEL_WARN) {
            Log.w(mTag, msg);
        }
    }

    /**
     * 以级别为 w 的形式输出Throwable
     */
    public static void w(Throwable tr) {
        if (mDebuggable >= LEVEL_WARN) {
            Log.w(mTag, "", tr);
        }
    }

    /**
     * 以级别为 w 的形式输出LOG信息和Throwable
     */
    public static void w(String msg, Throwable tr) {
        if (mDebuggable >= LEVEL_WARN && null != msg) {
            Log.w(mTag, msg, tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(String msg) {
        if (mDebuggable >= LEVEL_ERROR) {
            if (!TextUtils.isEmpty(msg)) {
                if (msg.length() > 4000) {
                    //                    Log.v(TAG, "sb.length = " + responseInfo.result.length());
                    int chunkCount = msg.length() / 4000;     // integer division
                    for (int i = 0; i <= chunkCount; i++) {
                        int max = 4000 * (i + 1);
                        if (max >= msg.length()) {
                            Log.e(mTag, "chunk " + i + " of " + chunkCount + ":" + msg.substring(4000 * i));
                        } else {
                            Log.e(mTag, "chunk " + i + " of " + chunkCount + ":" + msg.substring(4000 * i, max));
                        }
                    }
                } else {
                    Log.e(mTag, msg.toString());
                }
            }
        }
    }

    /**
     * 以级别为 e 的形式输出Throwable
     */
    public static void e(Throwable tr) {
        if (mDebuggable >= LEVEL_ERROR) {
            Log.e(mTag, "", tr);
        }
    }

    /**
     * 以级别为 e 的形式输出LOG信息和Throwable
     */
    public static void e(String msg, Throwable tr) {
        if (mDebuggable >= LEVEL_ERROR && null != msg) {
            Log.e(mTag, msg, tr);
        }
    }
    /**
     * 把Log存储到文件中
     *
     * @param log
     *            需要存储的日志
     * @param path
     *            存储路径
     */
  /*public static void log2File(String log, String path) {
        log2File(log, path, true);
	}
*/
    /*public static void log2File(String log, String path, boolean append) {
        synchronized (mLogLock) {
			FileUtils.writeFile(log + "\r\n", path, append);
		}
	}*/

    /**
     * 以级别为 e 的形式输出msg信息,附带时间戳，用于输出一个时间段起始点
     *
     * @param msg 需要输出的msg
     */
    public static void msgStartTime(String msg) {
        mTimestamp = System.currentTimeMillis();
        if (!TextUtils.isEmpty(msg)) {
            e("[Started：" + mTimestamp + "]" + msg);
        }
    }

    /**
     * 以级别为 e 的形式输出msg信息,附带时间戳，用于输出一个时间段结束点* @param msg 需要输出的msg
     */
    public static void elapsed(String msg) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - mTimestamp;
        mTimestamp = currentTime;
        e("[Elapsed：" + elapsedTime + "]" + msg);
    }

    public static <T> void printList(List<T> list) {
        if (list == null || list.size() < 1) {
            return;
        }
        int size = list.size();
        i("---begin---");
        for (int i = 0; i < size; i++) {
            i(i + ":" + list.get(i).toString());
        }
        i("---end---");
    }

    public static <T> void printArray(T[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        int length = array.length;
        i("---begin---");
        for (int i = 0; i < length; i++) {
            i(i + ":" + array[i].toString());
        }
        i("---end---");
    }
}
