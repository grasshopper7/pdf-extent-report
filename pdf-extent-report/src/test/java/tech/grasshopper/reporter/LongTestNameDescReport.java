package tech.grasshopper.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LongTestNameDescReport {

	public static void main(String[] args) {

		ExtentReports extent = new ExtentReports();

		ExtentPDFReporter pdf = new ExtentPDFReporter("reports/LongTextPDFReport.pdf");
		extent.attachReporter(pdf);

		ExtentSparkReporter spark = new ExtentSparkReporter("reports/LongTextSparkReport.html");
		extent.attachReporter(spark);

		extent.createTest(
				"Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels Log Levels",
				"Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levelsSpecify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levelsSpecify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levelsSpecify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels Specify all log levels ")
				.pass("pass").fail("fail").skip("skip").warning("warn").info("info").assignCategory("Category")
				.assignAuthor("Author").assignDevice("Device");

		extent.flush();
	}
}
