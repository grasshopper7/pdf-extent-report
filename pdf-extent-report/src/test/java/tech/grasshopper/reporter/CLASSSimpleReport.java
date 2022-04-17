package tech.grasshopper.reporter;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CLASSSimpleReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extent = new ExtentReports();
		extent.setMediaResolverPath(new String[] { "images" });
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);

		ExtentPDFReporter pdf = new ExtentPDFReporter("reports/CLASSSimplePDFReport.pdf");
		extent.attachReporter(pdf);
		pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json"));

		ExtentSparkReporter spark = new ExtentSparkReporter("reports/CLASSSimpleSparkReport.html");
		extent.attachReporter(spark);
		spark.loadXMLConfig("src/test/resources/extent-config.xml");

		extent.setSystemInfo("SYS1", "system info one");
		extent.setSystemInfo("SYS2", "system info two");

		Exception ex = null;
		try {
			int x = 1 / 0;
		} catch (Exception e) {
			ex = e;
		}

		extent.createTest("Log Levels", "Specify all log levels").pass("pass").fail("fail").skip("skip").warning("warn")
				.info("info").assignCategory("Category").assignAuthor("Author").assignDevice("Device");

		extent.createTest("Test Heirarchy").pass("passing test").createNode("Child Test", "Child Test description")
				.pass("child pass test").createNode("Grand Child Test").pass("grand child pass test");

		extent.createTest("Exception Test",
				"This is an Exception extent Test. This is an Exception extent Test. This is an Exception extent Test.")
				.fail(ex);

		extent.createTest("Generated Log").generateLog(Status.SKIP, "This is a generated log.");

		extent.createTest("Log And Generated").generateLog(Status.WARNING, "This is a combination with generated log.")
				.warning("This is a combination with log.");

		extent.createTest("Screen Capture").createNode("Test Media").addScreenCaptureFromPath("dashboard_default.png")
				.addScreenCaptureFromPath("json.json").addScreenCaptureFromPath("dashboard_default.png")
				.addScreenCaptureFromPath("dashboard_config.png").addScreenCaptureFromPath("dashboard_default.png")
				.addScreenCaptureFromPath("dashboard_config.png").createNode("Log Media")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("logo.png").build());

		extent.createTest("Empty Log Details").pass("");

		extent.flush();
	}
}
