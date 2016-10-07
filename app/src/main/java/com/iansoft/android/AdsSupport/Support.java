package com.iansoft.android.AdsSupport;

import com.iansoft.android.Device;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Service;
import android.app.Activity;
import android.content.Intent;

public class Support extends Service {

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return Service.START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}