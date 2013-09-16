package com.xuzhi.fragment;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment
{
	private boolean mDualPanel;

	private String[] mTitles;
	private ITitleClickListener mTitleClickListener;

	public interface ITitleClickListener
	{
		public void titleClick(String title);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);

		mTitles = ((FragmentDemoActivity) getActivity()).array;
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTitles));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);
	}
}
