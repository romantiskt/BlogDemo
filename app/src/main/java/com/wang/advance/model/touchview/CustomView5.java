package com.wang.advance.model.touchview;

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
 * data:2016/3/9 ..time:23:45
 * email: wyroman@163.com
 * projectName: ViewCode
 */
public class CustomView5 extends View{
    public CustomView5(Context context) {
        this(context, null);
    }

    public CustomView5(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    private Paint mPaint;// 画笔
    private Bitmap bitmapDis;// 目标位图
    private PorterDuffXfermode porterDuffXfermode;// 图形混合模式

    private int x, y;// 位图绘制时左上角的起点坐标
    private int screenW, screenH;// 屏幕尺寸
    private void initView(Context context) {
        // 实例化混合模式
        /*滤色产生的效果我认为是Android提供的几个色彩混合模式中最好的，它可以让图像焦媃幻化，有一种色调均和的感觉*/
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);
        // 实例化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 获取位图
        bitmapDis = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a3);

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

        // 先绘制一层带透明度的颜色
        canvas.drawColor(0xcc1c093e);

        // 设置混合模式
        mPaint.setXfermode(porterDuffXfermode);

        // 再绘制src源图
        canvas.drawBitmap(bitmapDis, x, y, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);

        // 还原画布
        canvas.restoreToCount(sc);
    }
}
