package com.iansoft.android.AdsSupport;

import com.iansoft.android.Device;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class AlarmReceiver extends BroadcastReceiver {
	Device device = new Device();

	@Override
	public void onReceive(Context context, Intent intent) {
		TurnOffData();
		Delay(10);
		TurnOnData();
		Delay(20);
	}

	private void Delay(int delayTime) {
		long lastEpoch = System.currentTimeMillis() / 1000;
		long currentEpoch = System.currentTimeMillis() / 1000;
		while (currentEpoch - lastEpoch < delayTime) {
			currentEpoch = System.currentTimeMillis() / 1000;
		}
	}
	private void TurnOnData() {
		device.GetInstance().setMobileDataEnabled(device.GetInstance().GetMainActivity(), true);
	}

	private void TurnOffData() {
		device.GetInstance().setMobileDataEnabled(device.GetInstance().GetMainActivity(), false);
	}
}