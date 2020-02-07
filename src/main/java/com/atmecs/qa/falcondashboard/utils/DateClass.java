package com.atmecs.qa.falcondashboard.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class DateClass {
	public static void main(String[] args) throws Exception {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		   
	}
}
