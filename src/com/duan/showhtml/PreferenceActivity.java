package com.duan.showhtml;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;

import com.duan.R;

public class PreferenceActivity extends android.preference.PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
		{
			PreferenceFrag prefFrag = new PreferenceFrag();
			FragmentManager manager = getFragmentManager();
			FragmentTransaction transaction = manager.beginTransaction();
			transaction.replace(android.R.id.content, prefFrag);
			transaction.commit();
		}
		else
		{
			addPreferencesFromResource(R.xml.preference);
		}
	}
}