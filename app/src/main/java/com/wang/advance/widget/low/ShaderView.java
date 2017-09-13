package com.wang.advance.widget.low;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.wang.advance.R;
import com.wang.tools.common.MeasureUtil;


/**
 * ShaderView
 *
 * @author Aige
 * @since 2014/11/24
 */
public class ShaderView extends View {
	private static final int RECT_SIZE = 400;// 矩形尺寸的一半

	private Paint mPaint;// 画笔

	private int left, top, right, bottom;// 矩形坐上右下坐标
	private int screenX, screenY;

	public ShaderView(Context context) {
		this(context,null);
	}

	public ShaderView(Context context, AttributeSet attrs) {
		super(context, attrs);

		// 获取屏幕尺寸数据
		int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

		// 获取屏幕中点坐标
		int screenX = screenSize[0] / 2;
		int screenY = screenSize[1] / 2;

		// 计算矩形左上右下坐标值
		left = screenX - RECT_SIZE;
		top = screenY - RECT_SIZE;
		right = screenX + RECT_SIZE;
		bottom = screenY + RECT_SIZE;

		// 实例化画笔
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

		// 获取位图
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);

		/*Shader.TileMode.CLAMP  拉伸
		* Shader.TileMode.MIRROR 镜像
		* Shader.TileMode.REPEAT 重复*/


		// 设置着色器
		mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// 绘制矩形
				canvas.drawRect(left, top, right, bottom, mPaint);
//		canvas.drawRect(0, 0, screenX * 2, screenY * 2, mPaint);
	}
}
