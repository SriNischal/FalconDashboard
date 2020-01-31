package com.atmecs.qa.falcondashboard.utils;

import java.util.Random;

import org.testng.annotations.Test;

public class RandomNumber {
	int randomNumber;
	@Test
	public int generateRandomNumber()
	{
	Random objGenerator = new Random();
	   for (int iCount = 0; iCount< 1; iCount++){
	     randomNumber = objGenerator.nextInt(5);
	     System.out.println("Random No : " + randomNumber);
	    }
	   return randomNumber;

}
}
