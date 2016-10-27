package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;

import android.app.Activity;
import android.app.ActivityManager;

import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.view.View;

import android.os.IBinder;
import android.app.Service;
import android.widget.Toast;
import android.content.Intent;

public class Support extends Service {
	private static Support m_sInstance = null;
	public static Support GetInstance() {
		if (m_sInstance == null) {
			m_sInstance = new Support();
		}
		return m_sInstance;
	}

	public Support() {
		if (m_sInstance == null) {
			m_sInstance = this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "service created", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Toast.makeText(this, "service started", Toast.LENGTH_LONG).show();
		StartSupport();
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "service destroyed", Toast.LENGTH_LONG).show();
	}

	private void StartSupport() {
		int currentSecond = (int)System.currentTimeMillis() / 1000 % 60;

		TurnOffData();
		Delay(10 + currentSecond);

		TurnOnData();
		Delay(20 + currentSecond);

		StartApplication("com.iansoft.android.ExchangeRates");
		Delay(20 + currentSecond);

		//ClickAds();
		//Delay(30 + currentSecond);

		PressHomeKey();
		Delay(60 + currentSecond);

		StopApplication("com.iansoft.android.ExchangeRates");
	}
	public void Delay(int delayTime) {
		Toast.makeText(this, "Delay: " + delayTime, Toast.LENGTH_LONG).show();
		try {
			Thread.sleep(delayTime * 1000);
		} catch (Exception e) {
			Log.print(e.toString());
		}
	}

	public void ClickAds() {
		Toast.makeText(this, "ClickAds", Toast.LENGTH_LONG).show();
		Shell.GetInstance().Execute("input tap 370 700");
	}

	public void TurnOnData() {
		Toast.makeText(this, "TurnOnData", Toast.LENGTH_LONG).show();
		Shell.GetInstance().Execute("svc data enable");
	}

	public void TurnOffData() {
		Toast.makeText(this, "TurnOffData", Toast.LENGTH_LONG).show();
		Shell.GetInstance().Execute("svc data disable");
	}

	public void PressHomeKey() {
		Toast.makeText(this, "PressHomeKey", Toast.LENGTH_LONG).show();
		Shell.GetInstance().Execute("input keyevent 3");
	}

	public void StopApplication(String packageName) {
		Toast.makeText(this, "StopApplication", Toast.LENGTH_LONG).show();
		Shell.GetInstance().Execute("am force-stop " + packageName);
	}

	public void StartApplication(String packageName) {
		Toast.makeText(this, "StartApplication", Toast.LENGTH_LONG).show();
		Shell.GetInstance().Execute("monkey -p " + packageName + " -c android.intent.category.LAUNCHER 1");
	}
}