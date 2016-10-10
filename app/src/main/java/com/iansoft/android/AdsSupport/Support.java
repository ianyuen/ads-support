package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;

import android.app.Activity;
import android.app.ActivityManager;

import android.content.Intent;
import android.content.Context;
import android.content.ComponentName;

public class Support {
	private static Support m_sInstance = null;

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