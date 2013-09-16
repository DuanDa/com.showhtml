package com.duan.showhtml;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.duan.view.MyImageView;

public class ReleaseActivity extends ActionBarActivity
{
	private static final String TAG = ReleaseActivity.class.getSimpleName();

	private RelativeLayout rl;
	private MyImageView iv_my;

	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.release);

		initResources();
	}

	private void initResources()
	{
		rl = (RelativeLayout) findViewById(R.id.rl);
		iv_my = (MyImageView) findViewById(R.id.iv_myImageView);
//		iv_my.setImageResource(R.drawable.sammy);
	}

	@Override
	protected void onStop()
	{
		super.onStop();
		System.gc();
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "---> onDestroy()");
	}

	@Override
	public void onBackPressed()
	{
		super.onBackPressed();

		Log.i(TAG, "---> onBackPressed()");
		if (rl != null)
		{
//			rl.removeAllViews();
//			System.gc();

			ActionBar bar = getSupportActionBar();
			bar.setTitle("Show");
			bar.setSubtitle("subtitle");
			bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.bar));

			/** Disable the invisible buttons **/
//			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

			/** Enable home icon **/
			bar.setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public void onDetachedFromWindow()
	{
		super.onDetachedFromWindow();
		Log.i(TAG, "---> onDetachedFromWindow()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_actionbar, menu);
		MenuItem searchItem = menu.findItem(R.id.search);
//		SearchView searchView = (SearchView) searchItem.getActionView();

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		switch (id)
		{
			case android.R.id.home:
				Toast.makeText(this, "Home pressed", 1).show();
				break;
		}
		return true;
	}
}
