package com.duan.showhtml;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.duan.R;
import com.duan.adapter.DAdapter;
import com.duan.beans.Family;
import com.duan.beans.Person;
import com.duan.model.WebPageUtil;
import com.thoughtworks.xstream.XStream;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class MainActivity extends Activity implements View.OnClickListener//, LoaderManager.LoaderCallbacks<Cursor>
{
	private static final String TAG = MainActivity.class.getSimpleName();

	private Context mContext;
    private boolean bIsStarted;

	private ListView lv;

	private LoaderManager manager;
	private DAdapter adapter;

	private Button btn_preference;
	private Button btn_release;
	private Button btn_fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		System.out.println("activity:" + TAG);
		setContentView(R.layout.activity_main);
		
		initResources();

		new Login(this);
	}

	private void initResources()
	{
		Log.i(TAG, "-->initResources()");
		mContext = MainActivity.this;

//		manager = getLoaderManager();
//		manager.initLoader(100, null, this);

		findViewById(R.id.btn).setOnClickListener(this);
		findViewById(R.id.btn_add).setOnClickListener(this);
		findViewById(R.id.btn_delete).setOnClickListener(this);
		findViewById(R.id.btn_preference).setOnClickListener(this);
		findViewById(R.id.btn_release).setOnClickListener(this);
		findViewById(R.id.btn_fragment).setOnClickListener(this);
		findViewById(R.id.btn_jsp).setOnClickListener(this);
		lv = (ListView) findViewById(R.id.lv);

        bIsStarted = true;
	}

	private void disDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		builder.setMessage(Html.fromHtml(getHTMLString()));
		builder.show();
	}
	
	private String getHTMLString()
	{
		String str;
		
		InputStream is = getResources().openRawResource(R.raw.license);
		StringWriter writer = new StringWriter();
		 try {
		     IOUtils.copy(is, writer);
		 } catch (IOException e) {
		     e.printStackTrace();
		 }
		str = writer.toString();
		 
		return str;
	}

	@Override
	public void onClick(View view)
	{
		switch (view.getId())
		{
			case R.id.btn:
//				System.out.println("msg...");
//				Logger log = Logger.getLogger(MainActivity.class);
//				log.debug("debug msg...");
//				disDialog();

//				DBService dbService = new DBService(mContext);
//				SQLiteDatabase sqldb = dbService.getWritableDatabase();

//				String sql = "INSERT INTO ShowHTMLTable VALUES (4, 'jack', 'china')";
//				sqldb.execSQL(sql);
//
//				sql = "INSERT INTO ShowHTMLTable VALUES (5, 'jim', 'japan')";
//				sqldb.execSQL(sql);
//
//				sql = "INSERT INTO ShowHTMLTable VALUES (6, 'jone', 'singapore')";
//				sqldb.execSQL(sql);

//				Cursor cursor = sqldb.query("ShowHTMLTable", null, null, null, null, null, null);
//				if (cursor.moveToNext())
//					System.out.println(cursor.getString(cursor.getColumnIndex("name")));

				ContentResolver contentResolver = getContentResolver();
				Uri uri = Uri.parse("content://com.duan.provider/person");
				String[] projection = null;
				String selection = null;
				String[] selectionArgs = null;
				String sortOrder = null;
				Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
//				while (cursor.moveToNext())
//					System.out.println(cursor.getString(cursor.getColumnIndex("name")));

				lv.setAdapter(new DAdapter(mContext, cursor));
				break;
			case R.id.btn_add:
				addDB();
				break;
			case R.id.btn_delete:
//				deleteDB();
				xml();
				break;
			case R.id.btn_preference:
				startActivity(new Intent(this, PreferenceActivity.class));
				break;
			case R.id.btn_release:
				startActivity(new Intent(this, ReleaseActivity.class));
//				Byte[] array = new Byte[325740];
				break;
			case R.id.btn_fragment:
				startActivity(new Intent(this, FragmentDemo.class));
				break;
			case R.id.btn_jsp:
				new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						parseJSP();
					}
				}).start();
				break;
		}
	}

	private void parseJSP()
	{
		try
		{
			//String url = "http://m.weathercn.com/common/index.do?cid=0101010102&pid=010101";
			//WebPageUtil webpage = new WebPageUtil().processUrl(url);
			//String header = webpage.getMsgHeader();
			//String content = webpage.getWebContent();
			//System.out.println("header:" + header + "/" + "content:" + content);
			new WebPageUtil().process();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void xml()
	{
		InputStream is = getResources().openRawResource(R.raw.download);
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(is));

		XStream stream = new XStream();
//		Object obj = stream.fromXML(br);
		stream.processAnnotations(Family.class);
		stream.processAnnotations(Person.class);
		Family family = (Family) stream.fromXML(getResources().openRawResource(R.raw.download));
		System.out.println(family);
	}

	private void addDB()
	{
		ContentResolver contentResolver = getContentResolver();
		ContentValues values = new ContentValues();
		values.put("name", "Jack");
		values.put("address", "Japan");
		Uri uri = Uri.parse("content://com.duan.provider/person");
		uri = contentResolver.insert(uri, values);
//		if (uri != null)
//			manager.restartLoader(100, null, this);
	}

	private void deleteDB()
	{
		ContentResolver contentResolver = getContentResolver();
		Uri uri = Uri.parse("content://com.duan.provider/person");
		int num = contentResolver.delete(uri, null, null);
//		if (num > 0)
//			manager.restartLoader(100, null, this);
	}


//	@Override
//	public Loader<Cursor> onCreateLoader(int i, Bundle bundle)
//	{
//		Log.i(TAG, "-->onCreateLoader()");
//		return new CursorLoader(mContext, Uri.parse("content://com.duan.provider/person"), null, null, null, null);
//	}
//
//	@Override
//	public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor)
//	{
//		Log.i(TAG, "-->onLoadFinished()");
//		lv.setAdapter(new DAdapter(mContext, cursor));
//	}
//
//	@Override
//	public void onLoaderReset(Loader<Cursor> cursorLoader)
//	{
//		Log.i(TAG, "-->onLoaderReset()");
//		lv.setAdapter(null);
//	}
}