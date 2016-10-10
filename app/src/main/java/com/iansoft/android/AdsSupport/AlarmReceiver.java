package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;
import com.iansoft.android.Device;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class AlarmReceiver extends BroadcastReceiver {
	Device device = new Device();

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.print("");
		TurnOffData();
		Delay(10);
		TurnOnData();
		Delay(20);
		//Support.GetInstance().StartApplication(context, "com.iansoft.android.ExchangeRates", "com.iansoft.android.ExchangeRates.Splash");
		Delay(20);
		//Support.GetInstance().StopApplication(context, "com.iansoft.android.ExchangeRates");

	}

	private void Delay(int delayTime) {
		Log.print("delayTime: " + delayTime);
		long lastEpoch = System.currentTimeMillis() / 1000;
		long currentEpoch = System.currentTimeMillis() / 1000;
		while (currentEpoch - lastEpoch < delayTime) {
			currentEpoch = System.currentTimeMillis() / 1000;
		}
	}
	private void TurnOnData() {
		Log.print("");
		device.GetInstance().setMobileDataEnabled(device.GetInstance().GetMainActivity(), true);
	}

	private void TurnOffData() {
		Log.print("");
		device.GetInstance().setMobileDataEnabled(device.GetInstance().GetMainActivity(), false);
	}
}