package com.duan.showhtml;

import android.app.Application;

/**
 * Created by Devin on 2/9/13.
 */
public class MyApplication extends Application
{
	private static final String TAG = MyApplication.class.getSimpleName();

	public void onCreate()
	{
		super.onCreate();
		System.out.println("application:" + TAG);
	}
}
