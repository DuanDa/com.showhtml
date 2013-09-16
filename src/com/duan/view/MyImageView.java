package com.duan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class MyImageView extends ImageView
{
	private static final String TAG = MyImageView.class.getSimpleName();

	public MyImageView(Context context)
	{
		super(context);
	}

	public MyImageView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public MyImageView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		Log.i(TAG, "---> onDraw()");
		super.onDraw(canvas);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom)
	{
		Log.i(TAG, "---> onLayout()");
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		Log.i(TAG, "---> onMeasure()");
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onAttachedToWindow()
	{
		Log.i(TAG, "---> onAttachedToWindow()");
		super.onAttachedToWindow();
	}

	@Override
	protected void onDetachedFromWindow()
	{
		Log.i(TAG, "---> onDetachedFromWindow()");
		super.onDetachedFromWindow();
	}
}
