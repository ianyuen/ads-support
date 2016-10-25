package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;

import java.io.DataOutputStream;

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
		try {
			Thread.sleep(delayTime);
		} catch (Exception e) {
			Log.print(e.toString());
		}
	}

	public void ClickAds() {
		Log.print();
		ExecuteShell("input tap 90 230");
	}

	public void TurnOnData() {
		Log.print();
		ExecuteShell("svc data enable");
	}

	public void TurnOffData() {
		Log.print();
		ExecuteShell("svc data disable");
	}

	public void PressHomeKey() {
		Log.print();
		ExecuteShell("input keyevent 3");
	}

	public void StopApplication(String packageName) {
		Log.print();
		ExecuteShell("am force-stop " + packageName);
	}

	public void StartApplication(String packageName) {
		Log.print();
		ExecuteShell("monkey -p " + packageName + " -c android.intent.category.LAUNCHER 1");
	}

	public void ExecuteShell(String command) {
		Log.print("command: " + command);
		Process process = null;
		try {
    		process = Runtime.getRuntime().exec("su");
			DataOutputStream outputStream = new DataOutputStream(process.getOutputStream());

			command = command + "\n";
			outputStream.write((command).getBytes());
			outputStream.flush();
    		outputStream.write("exit\n".getBytes());
			outputStream.flush();
    		process.waitFor(); 
		} catch (Exception e) {
    		Log.print(e.toString());
		} finally { 
    		if (process != null) { 
        		process.destroy(); 
    		} 
		}
	}
}