

package com.wang.tools.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.widget.Toast;

import com.wang.tools.CommonEngine;
import com.wang.tools.R;


/**
 * Created by wangyang
 * email: wyroman@163.com
 */
public class SingleToast {

    Context mContext;
    /** 之前显示的内容 */
    private static String oldMsg ;
    /** Toast对象 */
    private static Toast mToast = null ;
    /** 第一次时间 */
    private static long oneTime = 0 ;
    /** 第二次时间 */
    private static long twoTime = 0 ;
    public SingleToast(Context mContext) {
        this.mContext = mContext;
        mToast = new Toast(mContext);
        mToast = Toast.makeText(mContext, "", Toast.LENGTH_SHORT);
    }
    public static SingleToast INSTANCE;
    public static void init(@NonNull Context context){
        if (INSTANCE == null) {
            synchronized (SingleToast.class) {
                if (INSTANCE == null)
                     INSTANCE = new SingleToast(context);
            }
        }
    }

    public static SingleToast getInstance() {
        if(INSTANCE==null){
            INSTANCE=new SingleToast(CommonEngine.getContext());
        }

        return INSTANCE;
    }
    public void showButtomToast(String msg) {
        if(mToast == null){
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.BOTTOM, 0, mContext.getResources().getDimensionPixelOffset(R.dimen.toast_y));
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show() ;
            oneTime = System.currentTimeMillis() ;
        }else{
            twoTime = System.currentTimeMillis() ;
            if(msg.equals(oldMsg)){
                if(twoTime - oneTime > Toast.LENGTH_SHORT){
                    mToast.setText(msg);
                    mToast.show() ;
                }
            }else{
                oldMsg = msg ;
                mToast.setText(msg) ;
                mToast.show() ;
            }
        }
        oneTime = twoTime ;
    }

    public void showButtomToast(int messageId) {
        mToast.setText(messageId);
        mToast.setGravity(Gravity.BOTTOM, 0, mContext.getResources().getDimensionPixelOffset(R.dimen.toast_y));
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showMiddleToast(int id) {
        mToast.setText(id);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showMiddleToast(String msg) {
        if(mToast == null){
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.BOTTOM, 0, mContext.getResources().getDimensionPixelOffset(R.dimen.toast_y));
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show() ;
            oneTime = System.currentTimeMillis() ;
        }else{
            twoTime = System.currentTimeMillis() ;
            if(msg.equals(oldMsg)){
                if(twoTime - oneTime > Toast.LENGTH_SHORT){
                    mToast.show() ;
                }
            }else{
                oldMsg = msg ;
                mToast.setText(msg) ;
                mToast.show() ;
            }
        }
        oneTime = twoTime ;
    }

    public void showMiddleToast(String msg, int duration) {
        mToast.setText(msg);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.setDuration(duration);
        mToast.show();
    }

    public void showMiddleToastLong(String msg) {
        mToast.setText(msg);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }

    public static void showMiddleToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void showMiddleToast(Context context, int message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


}
