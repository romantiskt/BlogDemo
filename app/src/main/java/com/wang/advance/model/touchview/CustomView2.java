package com.wang.advance.model.touchview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.wang.advance.R;
import com.wang.tools.common.MeasureUtil;


/**
 * Created by Administrator on 2016/3/9.
 */
public class CustomView2 extends View {
    public CustomView2(Context context) {
        super(context, null);
    }

    public CustomView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    Paint mPaint;
    Bitmap mBitmap;
    int x,w;
    int y,h;
//    AvoidXfermode xfermode;
    private void initView(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.guide_zhongqiu_2);
        x = MeasureUtil.getScreenSize((Activity) context)[0] / 2 - mBitmap.getWidth() / 2;
        y = MeasureUtil.getScreenSize((Activity) context)[1] / 2 - mBitmap.getHeight() / 2;
        w = MeasureUtil.getScreenSize((Activity) context)[0] / 2 + mBitmap.getWidth() / 2;
        h = MeasureUtil.getScreenSize((Activity) context)[1] / 2 + mBitmap.getHeight() / 2;
        /*注意,这个模式需要将硬件加速关闭,可在清单文件中的application节点下关闭android:hardwareAccelerated="false"
        * Mode.TARGET 与设定颜色相同时才会去染色, tolearance为容差值,即可以偏离指定颜色多少
        * AvoidXfermode.Mode.AVOID与上面相反,不同才会染色*/
//        xfermode=new AvoidXfermode(0XFFFF0000,0, AvoidXfermode.Mode.AVOID);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*先画位图*/
        canvas.drawBitmap(mBitmap, x, y, mPaint);

        // “染”什么色是由我们自己决定的
        mPaint.setARGB(255, 211, 53, 243);

        // 设置AV模式
//        mPaint.setXfermode(xfermode);
        /*然后再给位图染上色*/
        canvas.drawRect(x,y,w,h,mPaint);
    }
}
