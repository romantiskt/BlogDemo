/**
 * Copyright 2014  XCL-Charts
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @Project XCL-Charts
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @Copyright Copyright (c) 2014 XCL-Charts (www.xclcharts.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.0
 */
package com.wang.advance.model.touchview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.wang.tools.common.LogUtils;
import com.wang.tools.common.UIUtils;
import com.wang.tools.common.XChartCalc;

/**
 * 环形图（双环，）
 */
public class AnnularView extends View {
    private int ScrWidth, ScrHeight;    //演示用的百分比例,实际使用中，即为外部传入的比例参数
    private final float arrPer[] = new float[]{20f, 30f, 10f, 40f}; //RGB颜色数组
    private final int arrColorRgb[][] = {{11, 106, 231}, {247, 58, 102}, {253, 180, 90}, {52, 194, 188}};
    private float[] sourceData;
    private String[] desc;

    public AnnularView(Context context) {
        this(context, null);
    }

    public AnnularView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSourceData(float[] sourceData, String[] desc) {
        this.sourceData = sourceData;
        this.desc = desc;
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LogUtils.d("onMeasure");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        LogUtils.d("onSizeChanged");
        ScrHeight = h;
        ScrWidth = w;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        LogUtils.d("onLayout");
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        LogUtils.d("onDraw");
        //画布背景
        canvas.drawColor(Color.WHITE);

        float cirY = ScrHeight / 2;
        float cirX = ScrWidth / 4;
        float radius = ScrHeight / 3;//150;

        float arcLeft = cirX - radius;
        float arcTop = cirY - radius;
        float arcRight = cirX + radius;
        float arcBottom = cirY + radius;
        RectF arcRF0 = new RectF(arcLeft, arcTop, arcRight, arcBottom);

        //画笔初始化
        Paint PaintArc = new Paint();
        PaintArc.setAntiAlias(true);

        Paint PaintLabel = new Paint();
        PaintLabel.setAntiAlias(true);
        PaintLabel.setTextSize(UIUtils.dp2px(11));
        PaintLabel.setColor(Color.rgb(48,47,53));


        //位置计算类
        XChartCalc xcalc = new XChartCalc();

        float Percentage = 0.0f;
        float CurrPer = 0.0f;
        int i = 0;
        if(sourceData==null?true:sourceData.length==0)return;
        int sourceSum = getSumForSource(sourceData);
        final float childH = (arcBottom - arcTop) / sourceData.length;
        final int childW = ScrWidth / 2 + 30;
        for (i = 0; i < sourceData.length; i++) {
            //将百分比转换为饼图显示角度
            Percentage = 360 * (sourceData[i] / sourceSum);
            Percentage = (float) (Math.round(Percentage * 100)) / 100;
            //分配颜色
            PaintArc.setARGB(255, arrColorRgb[i][0], arrColorRgb[i][1], arrColorRgb[i][2]);

            //在饼图中显示所占比例
            canvas.drawArc(arcRF0, CurrPer, Percentage, true, PaintArc);
            //计算百分比标签
            xcalc.CalcArcEndPointXY(cirX, cirY, radius - radius / 2 / 2, CurrPer + Percentage / 2);
            //标识
//                        canvas.drawText(Float.toString(Math.round((sourceData[i] * 100 / sourceSum) * 100) * 0.01f) + "%", xcalc.getPosX(), xcalc.getPosY(), PaintLabel);
            //下次的起始角度
            CurrPer += Percentage;
            float childStartY = arcTop + UIUtils.dp2px(20) + (i * childH);
            //绘制右边说明
            canvas.drawCircle(childW, childStartY, 12, PaintArc);
            PaintLabel.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(desc[i], childW + UIUtils.dp2px(8), childStartY+UIUtils.dp2px(5), PaintLabel);
            PaintLabel.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText((Math.round(sourceData[i]*100)*0.01)+"",ScrWidth-UIUtils.dp2px(13),childStartY+UIUtils.dp2px(5), PaintLabel);
        }

        //画圆心
        PaintArc.setColor(Color.WHITE);
        canvas.drawCircle(cirX, cirY, radius / 2, PaintArc);

    }

    private int getSumForSource(float[] sourceData) {
        int sum = 0;
        for (float source : sourceData) {
            sum += source;
        }
        return sum;
    }

}
