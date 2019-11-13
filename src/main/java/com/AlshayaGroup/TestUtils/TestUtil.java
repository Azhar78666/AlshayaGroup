package com.AlshayaGroup.TestUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.AlshayaGroup.TestSetup.TestSetup;



public class TestUtil extends TestSetup {

	public static String fname;
	
/*
	public static void logResponseInReport(Exception e) {
	//	testLevelLog.get().info("<details>" + "<summary>" + "<b>" + "<font color=" + "red>"
		//		+ "Click Here To See the Exception" + "</font>" + "</b >" + "</summary>" + e + "</details>" + " \n");

	}*/

	public static void archiveTestReport() {

		String reportName = "TestReport.html";

		String lastTestReportFilePath = "./src/test/resources/TestReport/TestReport.html";
		String archiveReportPath = System.getProperty("user.dir") + "/src/test/resources/archievedReport/";

		Date date = new Date();
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String formatedDate = dateFormate.format(date);
		String archiveTestReportName = formatedDate + "_" + reportName;

		File oldReport = new File(lastTestReportFilePath);

		File newFile = new File(archiveReportPath + archiveTestReportName);

		System.out.println(oldReport.exists());

		if (oldReport.exists()) {
			System.out.println("inside if");
			oldReport.renameTo(newFile);
			oldReport.delete();
		}

	}

	public static void captureScreenshot(String testCaseResult) {

		try {
			
			Date date = new Date();
			fname = date.toString().replace(":", "_").replace(" ", "_");
			
			
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./src/test/resources/ScreenShots/" + testCaseResult + fname + ".jpeg"));
			

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
	
	public static String fileName;
	public static void captureScreenshot() throws IOException{

		Date d = new Date();
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./test-output/html/" + fileName));
	}

	
}
