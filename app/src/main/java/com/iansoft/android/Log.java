package com.iansoft.android;

public class Log {
	public static void print() {
		StackTraceElement element = new Throwable().getStackTrace()[1];
		int line = element.getLineNumber();
		String file = element.getFileName();
		String method = element.getMethodName();

		String message = file + " - " + method + "() [line " + String.valueOf(line) + "]"; 
		android.util.Log.d("ianyuen", message);
	}

	public static void print(String msg) {
		StackTraceElement element = new Throwable().getStackTrace()[1];
		int line = element.getLineNumber();
		String file = element.getFileName();
		String method = element.getMethodName();

		String message = file + " - " + method + "() [line " + String.valueOf(line) + "] - " + msg; 
		android.util.Log.d("ianyuen", message);
	}
}