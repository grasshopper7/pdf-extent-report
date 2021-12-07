package tech.grasshopper.reporter;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MultiInstancesReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extent = new ExtentReports();
		extent.setMediaResolverPath(new String[] { "images" });

		ExtentPDFReporter pdf1 = new ExtentPDFReporter("reports/many/MultiplePDFReport1.pdf");
		extent.attachReporter(pdf1);
		pdf1.loadJSONConfig(new File("src/test/resources/pdf-config.json"));

		ExtentPDFReporter pdf2 = new ExtentPDFReporter("reports/many/MultiplePDFReport2.pdf");
		extent.attachReporter(pdf2);

		ExtentSparkReporter spark1 = new ExtentSparkReporter("reports/many/MultipleSparkReport1.html");
		extent.attachReporter(spark1);
		spark1.loadXMLConfig("src/test/resources/extent-config.xml");

		ExtentSparkReporter spark2 = new ExtentSparkReporter("reports/many/MultipleSparkReport2.html");
		extent.attachReporter(spark2);

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
				.addScreenCaptureFromPath("dashboard_config.png").createNode("Log Media")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("logo.png").build());

		extent.createTest("Empty Log Details").pass("");

		extent.flush();
	}
}
