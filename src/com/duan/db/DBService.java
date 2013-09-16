package com.duan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Devin on 23/7/13.
 */
public class DBService extends SQLiteOpenHelper
{
	private static final String TAG = DBService.class.getSimpleName();
	private static final int VERSION = 2;
	private static final String NAME = "ShowHTML.db";

	public DBService(Context context)
	{
		super(context, NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase)
	{
		Log.i(TAG, "-->onCreate()");
		String sql = "create table PERSON(id integer primary key autoincrement, name varchar(10), address varchar(10))";
		sqLiteDatabase.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
	{

	}
}
