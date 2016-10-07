package com.iansoft.android.AdsSupport;

import com.iansoft.android.Device;

import android.os.Bundle;
import android.app.Activity;

public class Splash extends Activity {
	Device device = new Device();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	private void TurnOnData() {
		device.GetInstance().setMobileDataEnabled(this, true);
	}

	private void TurnOffData() {
		device.GetInstance().setMobileDataEnabled(this, false);
	}
}