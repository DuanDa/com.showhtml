package com.duan.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.duan.R;

public class TitleFragment extends ListFragment
{
	private String TAG = TitleFragment.class.getSimpleName();

	private boolean mDualPanel;

	private String[] mTitles;
	private String mSelection;
	private ITitleClickListener mTitleClickListener;

	public interface ITitleClickListener
	{
		public void titleClick(String title);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Log.i(TAG, "--->onCreate()");
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		Log.i(TAG, "--->onAttach()");

		mTitleClickListener = (ITitleClickListener) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		Log.i(TAG, "--->onCreateView()");
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onStart()
	{
		super.onStart();
		Log.i(TAG, "--->onStart()");
	}

	@Override
	public void onResume()
	{
		super.onResume();
		Log.i(TAG, "--->onResume()");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		Log.i(TAG, "--->onConfigurationChanged()");
	}

	@Override
	public void onPause()
	{
		super.onPause();
		Log.i(TAG, "--->onPause()");
	}

	@Override
	public void onStop()
	{
		super.onStop();
		Log.i(TAG, "--->onStop()");
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		Log.i(TAG, "--->onViewCreated()");
	}

	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
		Log.i(TAG, "--->onDestroyView()");
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
		Log.i(TAG, "--->onDetach()");
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Log.i(TAG, "--->onDestroy()");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		Log.i(TAG, "--->onActivityCreated()");

		mTitles = getResources().getStringArray(R.array.Country_Title);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTitles));

		View detail = getActivity().findViewById(R.id.fl_detail);

		mDualPanel = detail != null && detail.getVisibility() == View.VISIBLE;
		if (mDualPanel)
		{
			if (savedInstanceState != null)
			{
				mSelection = savedInstanceState.getString("selection");
				mTitleClickListener.titleClick(mSelection);
			}
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);

		mSelection = mTitles[position];
		mTitleClickListener.titleClick(mSelection);
	}

	@Override
	public void onSaveInstanceState(Bundle outState)
	{
		super.onSaveInstanceState(outState);
		Log.i(TAG, "--->onSaveInstanceState()");

		outState.putString("selection", mSelection);
	}
}
