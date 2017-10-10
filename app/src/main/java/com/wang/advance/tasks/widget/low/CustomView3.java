package com.wang.advance.tasks.widget.low;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.wang.tools.common.MeasureUtil;
import com.wang.tools.common.PorterDuffBO;


/**
 * Created by Administrator on 2016/3/9.
 * data:2016/3/9 ..time:23:00
 * email: wyroman@163.com
 * projectName: ViewCode
 */
public class CustomView3 extends View {
    public CustomView3(Context context) {
        this(context, null);
    }

    public CustomView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    Paint mPaint;
    private PorterDuffBO porterDuffBO;// PorterDuffView类的业务对象
    PorterDuffXfermode xfermode;

    private static final int RECT_SIZE_SMALL = 400;// 左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 800;// 中间测试渐变正方形的尺寸大小
    private int screenW, screenH;// 屏幕尺寸
    private int s_l, s_t;// 左上方正方形的原点坐标
    private int d_l, d_t;// 右上方正方形的原点坐标
    private int rectX, rectY;// 中间正方形的原点坐标
    private void initView(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        porterDuffBO = new PorterDuffBO();
        xfermode=new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        calu(context);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画布颜色为黑色以便我们更好地观察
        canvas.drawColor(Color.BLACK);

        // 设置业务对象尺寸值计算生成左右上方的渐变方形
        porterDuffBO.setSize(RECT_SIZE_SMALL);

        /*
         * 画出左右上方两个正方形
         * 其中左边的的为src右边的为dis
         */
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), d_l, d_t, mPaint);

        /*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）我们将在1/3中学习到Canvas的全部用法这里就先follow me
         */
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        // 重新设置业务对象尺寸值计算生成中间的渐变方形
        porterDuffBO.setSize(RECT_SIZE_BIG);

        // 先绘制dis目标图
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), rectX, rectY, mPaint);

        // 设置混合模式,运用这样的模式会将颜色根据一定的算法进行混合
        //PS：Src为源图像，意为将要绘制的图像；Dis为目标图像，意为我们将要把源图像绘制到的图像
        mPaint.setXfermode(xfermode);

        // 再绘制src源图
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);

        // 还原画布
        canvas.restoreToCount(sc);
    }
    /**
     * 计算坐标
     *
     * @param context
     *            上下文环境引用
     */
    private void calu(Context context) {
        // 获取包含屏幕尺寸的数组
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        // 获取屏幕尺寸
        screenW = screenSize[0];
        screenH = screenSize[1];

        // 计算左上方正方形原点坐标
        s_l = 0;
        s_t = 0;

        // 计算右上方正方形原点坐标
        d_l = screenW - RECT_SIZE_SMALL;
        d_t = 0;

        // 计算中间方正方形原点坐标
        rectX = screenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (screenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }
}
