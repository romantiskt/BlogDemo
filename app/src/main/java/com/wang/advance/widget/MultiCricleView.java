package com.wang.advance.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/3/20.
 * data:2016/3/20 ..time:21:14
 * email: wyroman@163.com
 * projectName: ViewCode
 */
public class MultiCricleView extends View {
    private static final float STROKE_WIDTH = 1F / 256F, // 描边宽度占比
            LINE_LENGTH = 3F / 32F, // 线段长度占比
            CRICLE_LARGER_RADIU = 3F / 32F,// 大圆半径
            CRICLE_SMALL_RADIU = 5F / 64F,// 小圆半径
            ARC_RADIU = 1F / 8F,// 弧半径
            ARC_TEXT_RADIU = 5F / 32F;// 弧围绕文字半径

    private Paint strokePaint;// 描边画笔
    private TextPaint textPaint;
    private int size;// 控件边长

    private float strokeWidth;// 描边宽度
    private float ccX, ccY;// 中心圆圆心坐标
    private float largeCricleRadiu;// 大圆半径
    Paint mPaintStroke;
    Paint arcPaint;
    float line_length;
    float textOffsetY;

    public MultiCricleView(Context context) {
        this(context, null);
    }

    public MultiCricleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaintStroke();
    }

    private void initPaintStroke() {
        mPaintStroke = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        mPaintStroke.setStyle(Paint.Style.STROKE);
        mPaintStroke.setColor(Color.WHITE);
        mPaintStroke.setStrokeCap(Paint.Cap.ROUND);

        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG | Paint.SUBPIXEL_TEXT_FLAG);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textOffsetY = (textPaint.descent() + textPaint.ascent()) / 2;
        arcPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        size = w;
        strokeWidth = size * STROKE_WIDTH;
        largeCricleRadiu = size * CRICLE_LARGER_RADIU;
        ccX = size / 2;
        line_length = size * LINE_LENGTH;
        ccY = size / 2 + size * CRICLE_LARGER_RADIU;
        mPaintStroke.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(0xFFF29B76);
        canvas.drawCircle(ccX, ccY, largeCricleRadiu, mPaintStroke);
        canvas.drawText("wangyang",ccX,ccY-textOffsetY,textPaint);
        drawTopLeft(canvas);
        drawRight(canvas);
        drawLeft(canvas);
        drawButtom(canvas);
        drawTopRight(canvas);
    }

    private void drawButtom(Canvas canvas) {
        canvas.save();
        canvas.translate(ccX, ccY);
        canvas.rotate(-180);
        drawLineCircle(canvas);
        canvas.restore();
    }

    private void drawLeft(Canvas canvas) {
        canvas.save();
        canvas.translate(ccX, ccY);
        canvas.rotate(-90);
        drawLineCircle(canvas);
        canvas.restore();
    }

    private void drawRight(Canvas canvas) {
        canvas.save();
        canvas.translate(ccX, ccY);
        canvas.rotate(90);
        drawLineCircle(canvas);
        canvas.restore();
    }

    private void drawTopRight(Canvas canvas) {
        canvas.save();
        canvas.translate(ccX, ccY);
        canvas.rotate(30);
        drawLineCircle(canvas);
        drawArcRight(canvas);
        canvas.restore();
    }

    private void drawArcRight(Canvas canvas) {
        canvas.save();
        canvas.translate(0, -line_length * 3);
        canvas.rotate(-30);
        float arcRadiu = size * ARC_RADIU;

        RectF oval = new RectF(-arcRadiu, -arcRadiu, arcRadiu, arcRadiu);

        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setColor(0x55EC6941);
        canvas.drawArc(oval, -22.5F, -135, true, arcPaint);

        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setColor(Color.WHITE);
        canvas.drawArc(oval, -22.5F, -135, false, arcPaint);
        float arcTextRadiu = size * ARC_TEXT_RADIU;

        canvas.save();
        // 把画布旋转到扇形左端的方向
        canvas.rotate(-135F / 2F);

    /*
     * 每隔33.75度角画一次文本
     */
        for (float i = 0; i < 5 * 33.75F; i += 33.75F) {
            canvas.save();
            canvas.rotate(i);

            canvas.drawText("Aige", 0, -arcTextRadiu, textPaint);

            canvas.restore();
        }

//        canvas.restore();
//        canvas.restore();
    }

    private void drawLineCircle(Canvas canvas) {
        canvas.drawLine(0, -line_length, 0, -line_length * 2, mPaintStroke);
        canvas.drawCircle(0, -line_length * 3, largeCricleRadiu, mPaintStroke);
        canvas.drawText("wangyang", 0,-line_length * 3 - textOffsetY, textPaint);
    }

    private void drawTopLeft(Canvas canvas) {
        canvas.save();

        canvas.translate(ccX, ccY);
        canvas.rotate(-30);

        drawLineCircle(canvas);
        canvas.drawLine(0, -largeCricleRadiu * 4, 0, -line_length * 5, mPaintStroke);
        canvas.drawCircle(0, -line_length * 6, largeCricleRadiu, mPaintStroke);
        canvas.drawText("wangyang", -0, -line_length * 6 - textOffsetY,textPaint);
        canvas.restore();
    }
}
