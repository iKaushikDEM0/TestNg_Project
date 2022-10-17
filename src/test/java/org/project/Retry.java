package org.project;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;;

public class Retry implements IRetryAnalyzer {
	int min = 0;
	int max = 3;
	public boolean retry(ITestResult a) {
		if (min<max) {
			min++;
			return true;
		}
		return false;
	}
	

}
