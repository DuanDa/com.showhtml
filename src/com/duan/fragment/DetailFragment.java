package com.duan.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duan.R;

public class DetailFragment extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_detail, container, false);
		TextView tv_detail = (TextView) view.findViewById(R.id.tv_detail);
		tv_detail.setText(getArguments().getString("TITLE"));
		return view;
	}
}
