package ison.lib;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Func 
{
	//--- 时间戳转换为字符串时间格式  func.getTime(1471277423);
	static public String getTime(int time)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date(time*1000L));
		return date;
	}
	//---  时间戳转换为字符串时间格式  func.getTime(1471277423, "yyyy-MM-dd HH:mm:ss");
	static public String getTime(int time, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = sdf.format(new Date(time*1000L));
		return date;
	}
	//--- 获取当前时间戳  func.getTimeStemp();
	static public int getTimeStemp()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = null;
		try {
			time = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    int timeStemp = (int) (time.getTime()/1000);
	    return timeStemp;
	}
	//--- 时间转为时间戳  func.getTimeStemp("2016-08-04 10:23:43", "yyyy-MM-dd HH:mm:ss");
	static public int getTimeStemp(String date, String format) throws ParseException
	{
		 SimpleDateFormat simpleDateFormat =new SimpleDateFormat(format);
	     Date d=simpleDateFormat.parse(date);
	     int timeStemp = (int) (d.getTime()/1000);
	     return timeStemp;
	}
	
	

}
