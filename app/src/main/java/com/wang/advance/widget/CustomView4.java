package com.wang.advance.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.wang.advance.R;
import com.wang.tools.common.MeasureUtil;

/**
 * Created by Administrator on 2016/3/9.
 * data:2016/3/9 ..time:23:31
 * email: wyroman@163.com
 * projectName: ViewCode
 */
public class CustomView4 extends View {
    public CustomView4(Context context) {
        this(context, null);
    }

    public CustomView4(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    private Paint mPaint;// 画笔
    private Bitmap bitmapDis;// 目标位图
    private Bitmap bitmapSrc;//原图
    private PorterDuffXfermode porterDuffXfermode;// 图形混合模式

    private int x, y;// 位图绘制时左上角的起点坐标
    private int screenW, screenH;// 屏幕尺寸
    /*PorterDuff.Mode.DST_IN   计算方式：[Sa * Da, Sa * Dc]；Chinese：只在源图像和目标图像相交的地方绘制目标图像
    *
    * PorterDuff.Mode.DST_OUT  计算方式：[Da * (1 - Sa), Dc * (1 - Sa)]；Chinese：只在源图像和目标图像不相交的地方绘制目标图像
    * */
    private void initView(Context context) {
        // 实例化混合模式
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        // 实例化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 获取位图
        bitmapDis = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a3);
        bitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a3_mask);

        // 获取包含屏幕尺寸的数组
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        // 获取屏幕尺寸
        screenW = screenSize[0];
        screenH = screenSize[1];

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
        x = screenW / 2 - bitmapDis.getWidth() / 2;
        y = screenH / 2 - bitmapDis.getHeight() / 2;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        /*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）我们将在1/3中学习到Canvas的全部用法这里就先follow me
         */
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        // 先绘制dis目标图
        canvas.drawBitmap(bitmapDis, x, y, mPaint);

        // 设置混合模式
        mPaint.setXfermode(porterDuffXfermode);//设置此模式Mode.DST_IN,只有源头像和目标头像相交的地方才会绘制头像

        // 再绘制src源图
        canvas.drawBitmap(bitmapSrc, x, y, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);

        // 还原画布
        canvas.restoreToCount(sc);
    }
}
