package tech.grasshopper.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tech.grasshopper.reporter.ExtentPDFReporter;

public class Base {

	protected static ExtentReports extent;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");

		extent = new ExtentReports();

		System.out.println(extent);

		ExtentPDFReporter pdf = new ExtentPDFReporter("reports/SuiteReport.pdf");
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/SuiteReport.html");
		extent.attachReporter(spark, pdf);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");

		extent.flush();
	}
}
