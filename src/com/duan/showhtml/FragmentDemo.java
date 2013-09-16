package com.duan.showhtml;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.duan.R;
import com.duan.fragment.DetailFragment;
import com.duan.fragment.TitleFragment;

public class FragmentDemo extends FragmentActivity implements TitleFragment.ITitleClickListener
{
	private static final String TAG = FragmentDemo.class.getSimpleName();

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_demo);
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Log.i(TAG, "--->onStart()");
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		Log.i(TAG, "--->onResume()");
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		Log.i(TAG, "--->onPause()");
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		Log.i(TAG, "--->onStop()");
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		Log.i(TAG, "--->onRestart()");
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "--->onDestroy()");
	}

	@Override
	public void titleClick(String title)
	{
		Bundle bundle = new Bundle();
		DetailFragment detailFragment = new DetailFragment();
		bundle.putString("TITLE", title);
		detailFragment.setArguments(bundle);

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fl_detail, detailFragment);
		transaction.commit();
	}
}
