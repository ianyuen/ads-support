package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;
import com.iansoft.android.Device;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class AlarmReceiver extends BroadcastReceiver {
	Device device = new Device();
	Context context = null;

	@Override
	public void onReceive(Context context, Intent intent) {
		context = this.context;
		TurnOffData();
		Delay(100);
		TurnOnData();
		Delay(100);
	}

	private void Delay(int delayTime) {
		long lastEpoch = System.currentTimeMillis() / 1000;
		long currentEpoch = System.currentTimeMillis() / 1000;
		while (currentEpoch - lastEpoch < delayTime) {
			currentEpoch = System.currentTimeMillis() / 1000;
		}
	}
	private void TurnOnData() {
		Log.print("");
		device.GetInstance().setMobileDataEnabled(context, true);
	}

	private void TurnOffData() {
		Log.print("");
		device.GetInstance().setMobileDataEnabled(context, false);
	}
}