package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;
import com.iansoft.android.Device;

import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.view.View;

public class Splash extends Activity {
	private static Splash m_sInstance = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Support.GetInstance().SetMainActivity(this);
	}

	public void btnStopClicked(View view) {
		Log.print("");
		Support.GetInstance().SetMainView(view);
		StopSupport();
	}

	public void btnStartClicked(View view) {
		Log.print("");
		Support.GetInstance().SetMainView(view);
		StartSupport(10);
	}

	private void StopSupport() {
		Log.print("");
		AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(this, AlarmReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
		alarmManager.cancel(pendingIntent);
	}

	private void StartSupport(int delaySecond) {
		Log.print("");
		AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(this, AlarmReceiver.class);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
		alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), delaySecond * 1000, pendingIntent);
	}
}