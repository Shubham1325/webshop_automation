package com.webshopautomation.utility;
import java.util.Date;
public class JavaUtility 
{
	public static String getSystemDate()
	{
		Date dateObj=new Date();
		return dateObj.toString().replace(' ','_').replace(':','_');
		/*
		 * String date=dateObj+""; date=date.replace(' ','_'); return
		 * date=date.replace(':','_');
		 */
	}
}
