package com.ajita.common;

import java.sql.Timestamp;

public class Util {
	
	public static long currentTimestamp() {
		long now = System.currentTimeMillis();
		return now;
	}
	
	public static long dateStrToTimestamp(String dateStr) {
		Timestamp ts = new Timestamp(0);
		try {
			ts = Timestamp.valueOf(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts.getTime();
	}
	
	public static String getDetail(int id){
		String info = Sync.errorList_.get(id);
		return info == null ? "" : info;
	}

}
