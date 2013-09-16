package com.duan.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;

import com.duan.db.DBService;

/**
 * Created by Devin on 26/7/13.
 */
public class DContentProvider extends ContentProvider
{
	private DBService mDBservice;
	private static final int PERSONS = 1;
	private static final int PERSON = 2;
	private static final String AUTHORITY = "com.duan.provider";
	private static final UriMatcher mMatcher = new UriMatcher(UriMatcher.NO_MATCH);

	static
	{
		mMatcher.addURI(AUTHORITY, "person", PERSONS);
		mMatcher.addURI(AUTHORITY, "person/#", PERSON);
	}

	@Override
	public boolean onCreate()
	{
		mDBservice = new DBService(this.getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder)
	{
		SQLiteDatabase db = mDBservice.getReadableDatabase();
		Cursor cursor;

		switch (mMatcher.match(uri))
		{
			case PERSONS:
				cursor = db.query("PERSON", projection, selection, selectionArgs, null, null, sortOrder);
				break;
			case PERSON:
				long id = ContentUris.parseId(uri);
				String where = TextUtils.isEmpty(selection) ? "id = ?" : selection + "and id = ?";
				String[] params = new String[] { String.valueOf(id) };
				if (!TextUtils.isEmpty(selection) && selectionArgs != null)
				{
					params = new String[selectionArgs.length + 1];
					for (int i = 0; i < selectionArgs.length; i++)
					{
						params[i] = selectionArgs[i];
					}
				}
				cursor = db.query("PERSON", projection, where, params, null, null, sortOrder);
				break;
			default:
				throw new IllegalStateException("unknown uri:" + uri);
		}

		return cursor;
	}

	@Override
	public String getType(Uri uri)
	{
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues contentValues)
	{
		SQLiteDatabase db = mDBservice.getWritableDatabase();
		long id = 0;
		switch (mMatcher.match(uri))
		{
			case PERSONS:
				id = db.insert("PERSON", null, contentValues);
				return ContentUris.withAppendedId(uri, id);
			case PERSON:
				id = db.insert("PERSON", null, contentValues);
				String path = uri.toString();
				return Uri.parse(path.substring(0, path.lastIndexOf('/' + 1)) + id);
			default:
				throw new IllegalStateException("unknown uri:" + uri);
		}
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs)
	{
		SQLiteDatabase db = mDBservice.getWritableDatabase();
		switch (mMatcher.match(uri))
		{
			case PERSONS:
				return db.delete("PERSON", null, null);
			case PERSON:
				return db.delete("PERSON", selection, selectionArgs);
			default:
				throw new IllegalStateException("unknown uri:" + uri);
		}
	}

	@Override
	public int update(Uri uri, ContentValues contentValues, String s, String[] strings)
	{
		return 0;
	}
}
