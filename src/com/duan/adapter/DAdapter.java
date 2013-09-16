package com.duan.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Devin on 26/7/13.
 */
public class DAdapter extends BaseAdapter
{
	private Context mContext;
	private Cursor cursor;

	public DAdapter(Context context, Cursor cursor)
	{
		mContext = context;
		this.cursor = cursor;
	}

	@Override
	public int getCount()
	{
		return cursor.getCount();
	}

	@Override
	public Object getItem(int i)
	{
		return i;
	}

	@Override
	public long getItemId(int i)
	{
		return i;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup viewGroup)
	{
		if (convertView == null)
			convertView = new TextView(mContext);

		if (cursor != null && cursor.moveToPosition(position))
			((TextView) convertView).setText(cursor.getString(cursor.getColumnIndex("name")) + "/" + cursor.getString(cursor.getColumnIndex("address")));
 
		return convertView;
	}
}
