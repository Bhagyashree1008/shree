package Utility.Files;


	import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.bouncycastle.asn1.cms.Time;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;


	public class ListenersImplementationClass implements ITestListener
	{
		
		ExtentReports report;
		ExtentTest test;
		Date d=new Date();
		Time timestamp=new Time(d);
		@Override
		public void onTestStart(ITestResult result) {

			String methodName = result.getMethod().getMethodName();
			test = report.createTest(methodName);
			test.log(Status.INFO, "-> "+methodName+" - Test Execution started <-");

		}

		@Override
		public void onTestSuccess(ITestResult result) {
						String methodName = result.getMethod().getMethodName();
			test.log(Status.PASS, "-> "+methodName+" - Test is Passed <-");

		}
@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub

			String methodName = result.getMethod().getMethodName();
			test.log(Status.FAIL, "-> "+methodName+" - Test is Failed <-");
			test.log(Status.WARNING, result.getThrowable());

			String screenShotName = methodName+"-"+timestamp;

			
			TakesScreenshot ts = (TakesScreenshot) BaseClass.sDriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
			try {
				Files.copy(src, dst);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}




		}
@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub

			String methodName = result.getMethod().getMethodName();
			test.log(Status.SKIP, "-> "+methodName+" - Test is Skipped <-");
			test.log(Status.WARNING, result.getThrowable());
		}



		@Override
		public void onStart(ITestContext context) {

			System.out.println("-> Suite execution Started <-");

			ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+timestamp+".html");
			htmlReport.config().setDocumentTitle("Rogain Execution Report");
			htmlReport.config().setReportName("Rogain Report");
			htmlReport.config().setTheme(Theme.DARK);

			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("Base Browser", "edge");
			report.setSystemInfo("Base URL", "http://localhost:8888");
			report.setSystemInfo("Base Platform", "Windows 10");
			report.setSystemInfo("Reporter Name", "bhagya");


		}
		@Override
		public void onFinish(ITestContext context) {
			report.flush();

		}

	}

