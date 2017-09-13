package com.wang.advance.widget.low.loading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;


import com.wang.advance.R;

import java.util.ArrayList;

/**
 * 样式实现类，
 */
public class BallClipRotateIndicator extends Indicator {

    private float  degrees;
    private Bitmap bitmap;
    private int grayColor = Color.rgb(153, 153, 153);
    private int themeColor = Color.rgb(255, 110, 52);


    public BallClipRotateIndicator(Context mContext) {
        bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
        bitmap = bitmap.extractAlpha(); //从原位图中提取只包含alpha的位图

    }
    @Override
    public void draw(Canvas canvas, Paint paint) {

        float radius=getWidth()/3;
        float circleSpacing = radius/2;
        float x = (getWidth()) / 2;
        float y = (getHeight()) / 2;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.TRANSPARENT);
        canvas.drawCircle(x, y, radius, paint);//画背景
        canvas.save();

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(grayColor);//画灰色圈
        canvas.drawCircle(x, y, radius, paint);

        paint.setColor(themeColor);
        canvas.translate(x, y);
        RectF rectF = new RectF(-x + circleSpacing, -y + circleSpacing, 0 + x - circleSpacing, 0 + y - circleSpacing);
        float end = (degrees + 45)%360;
//        canvas.drawArc(rectF, degrees%360, end, false, paint);
        canvas.drawArc(rectF, 360*degrees, 90, false, paint);

        mPaint.setColor(themeColor);
        circleSpacing = circleSpacing * 2;
        RectF rectBitmap = new RectF(-x + circleSpacing, -y + circleSpacing, 0 + x - circleSpacing, 0 + y - circleSpacing);
        canvas.drawBitmap(bitmap, null, rectBitmap, paint);
    }

    @Override
    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> animators = new ArrayList<>();
//        ValueAnimator rotateAnim = ValueAnimator.ofFloat(0,90,180,270);
        ValueAnimator rotateAnim = ValueAnimator.ofFloat(0,1);
        rotateAnim.setDuration(2000);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setRepeatCount(-1);
        addUpdateListener(rotateAnim, new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degrees = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animators.add(rotateAnim);
        return animators;
    }

}
