package com.iansoft.android.AdsSupport;

import com.iansoft.android.Log;
import java.io.DataOutputStream;

public class Shell {
	private static Shell m_sInstance = null;
	public static Shell GetInstance() {
		if (m_sInstance == null) {
			m_sInstance = new Shell();
		}
		return m_sInstance;
	}

	public Shell() {
		if (m_sInstance == null) {
			m_sInstance = this;
		}
	}

	public void Execute(String command) {
		Process process = null;
		Log.print();
		try {
			Log.print();
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
				Log.print(); 
        		process.destroy(); 
    		} 
		}
	}
}