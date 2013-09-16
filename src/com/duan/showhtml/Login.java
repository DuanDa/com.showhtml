package com.duan.showhtml;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Devin on 20/6/13.
 */
public class Login
{
	public Login(Activity activity)
	{
		System.out.println("Activity:" + activity.toString());
	}

	public Login(Context context)
	{
		System.out.println("Context:" + context.toString());
	}
}
