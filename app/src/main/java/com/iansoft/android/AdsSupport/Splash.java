package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;

import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.view.View;
import android.widget.Toast;

public class Splash extends Activity {
	private static Splash m_sInstance = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Shell.GetInstance().Execute("");
	}

	public void btnStopClicked(View view) {
		Log.print();
		Toast.makeText(this, "btnStopClicked", Toast.LENGTH_LONG).show();
		stopService(new Intent(this, Support.class));
	}

	public void btnStartClicked(View view) {
		Log.print();
		Toast.makeText(this, "btnStartClicked", Toast.LENGTH_LONG).show();
		startService(new Intent(this, Support.class));
	}
}