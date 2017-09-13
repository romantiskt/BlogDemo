package com.wang.advance.widget.low;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wang.advance.R;
import com.wang.tools.common.MeasureUtil;


/**
 * Created by Administrator on 2016/3/9.
 */
public class CustomView1 extends View {
    Paint mPaint;
    Bitmap bitmap;
    private int x,y;
    public CustomView1(Context context) {
        this(context, null);
    }

    public CustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);//此标记抗锯齿
        /*混合模式,一个颜色值和后面的模式相结合,即混合,例如这里的绿色,然后模式是变暗
        * 这里各种模式和颜色搭配能产生出很多效果*/
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.ADD));

        // 获取位图
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.guide_zhongqiu_2);

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
        x = MeasureUtil.getScreenSize((Activity) context)[0] / 2 - bitmap.getWidth() / 2;
        y = MeasureUtil.getScreenSize((Activity) context)[1] / 2 - bitmap.getHeight() / 2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("wang","x="+x+"___y="+y);
        /*这里的x,y是指在手机屏幕上的位置,以手机屏幕左上角为0点,在手机屏幕上(即人的可见范围里 x>0,y>0)
        * ,相反,不可见范围内都<0,这里的drawbitmap中的x,y坐标即指从哪里开始画
        * */
        canvas.drawBitmap(bitmap,-x,-y,mPaint);
    }
}
