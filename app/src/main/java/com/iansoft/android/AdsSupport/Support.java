package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;
import com.iansoft.android.Device;

import android.app.Activity;
import android.app.ActivityManager;

import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;
import android.view.MotionEvent;
import android.os.SystemClock;
import android.view.View;

public class Support {
	private static Support m_sInstance = null;

	private View view = null;
	private Activity activity = null;

	public Support() {
		if (m_sInstance == null) {
			m_sInstance = this;
		}
	}

	public static Support GetInstance() {
		if (m_sInstance == null) {
			m_sInstance = new Support();
		}
		return m_sInstance;
	}

	public void Delay(int delayTime) {
		Log.print("delayTime: " + delayTime);
		long lastEpoch = System.currentTimeMillis() / 1000;
		long currentEpoch = System.currentTimeMillis() / 1000;
		while (currentEpoch - lastEpoch < delayTime) {
			currentEpoch = System.currentTimeMillis() / 1000;
		}
	}

	public void SetMainView(View view) {
		this.view = view;
	}

	public View GetMainView() {
		return view;
	}

	public void SetMainActivity(Activity activity) {
		this.activity = activity;
	}

	public Activity GetMainActivity() {
		return activity;
	}

	public void TurnOnData() {
		Log.print("");
		Device.GetInstance().setMobileDataEnabled(GetMainActivity(), true);
	}

	public void TurnOffData() {
		Log.print("");
		Device.GetInstance().setMobileDataEnabled(GetMainActivity(), false);
	}

	public void ClickAds() {
		Log.print("");
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis() + 100;
		float x = 400.0f;
		float y = 730.0f;
		int metaState = 0;
		MotionEvent motionEvent = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, x, y, metaState);
		Support.GetInstance().GetMainView().dispatchTouchEvent(motionEvent);
	}

	public void StopApplication(Context context, String packageName) {
		Log.print("");
		ActivityManager activityManager = (ActivityManager)context.getSystemService(Activity.ACTIVITY_SERVICE);
		activityManager.killBackgroundProcesses(packageName);
	}

	public void StartApplication(Context context, String packageName, String className) {
		Log.print("");
		Intent intent = new Intent();
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setComponent(new ComponentName(packageName, className));
		context.startActivity(intent);
	}
}