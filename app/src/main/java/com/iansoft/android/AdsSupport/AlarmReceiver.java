package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public class AlarmReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.print("");
		//Support.GetInstance().TurnOffData();
		Support.GetInstance().Delay(10);
		//Support.GetInstance().TurnOnData();
		Support.GetInstance().Delay(20);
		Support.GetInstance().StartApplication(context, "com.iansoft.android.ExchangeRates", "com.iansoft.android.ExchangeRates.Splash");
		Support.GetInstance().Delay(20);
		Support.GetInstance().ClickAds();
		Support.GetInstance().Delay(20);
		Support.GetInstance().StopApplication(context, "com.iansoft.android.ExchangeRates");

	}
}