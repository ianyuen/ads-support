package com.iansoft.android;

import com.iansoft.android.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.content.Context;
import android.telephony.TelephonyManager;

public class Device {
	private static Device m_sInstance = null;

	private Activity activity = null;

	public Device() {
		if (m_sInstance == null) {
			m_sInstance = this;
		}
	}

	public static Device GetInstance() {
		if (m_sInstance == null) {
			m_sInstance = new Device();
		}
		return m_sInstance;
	}

	public void SetMainActivity(Activity activity) {
		this.activity = activity;
	}

	public Activity GetMainActivity() {
		return activity;
	}

	public void setMobileDataEnabled(Context context, boolean enabled) {
		try {
			/*
			final ConnectivityManager conman = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
			final Class conmanClass = Class.forName(conman.getClass().getName());
			final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
			iConnectivityManagerField.setAccessible(true);
			final Object iConnectivityManager = iConnectivityManagerField.get(conman);
			final Class iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());
			final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
			setMobileDataEnabledMethod.setAccessible(true);
			setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
			*/

			TelephonyManager telephonyService = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
			Method setMobileDataEnabledMethod = telephonyService.getClass().getDeclaredMethod("setDataEnabled", boolean.class);
			if (null != setMobileDataEnabledMethod) {
				setMobileDataEnabledMethod.invoke(telephonyService, enabled);
			}
		} catch (Exception e) {
			Log.print(e.toString());
		}
	}
}