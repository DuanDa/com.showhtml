package com.duan.showhtml;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.duan.R;

public class PreferenceFrag extends PreferenceFragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//addPreferencesFromResource(R.xml.preference_google);
		addPreferencesFromResource(R.xml.preference_sample);
	}
}