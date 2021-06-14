package tech.grasshopper.reporter;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TESTComboReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extent = new ExtentReports();
		extent.setMediaResolverPath(new String[] { "images" });

		ExtentPDFReporter pdf = new ExtentPDFReporter("reports/TESTComboPDFReport.pdf");
		extent.attachReporter(pdf);
		// pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json"));

		ExtentSparkReporter spark = new ExtentSparkReporter("reports/TESTComboSparkReport.html");
		extent.attachReporter(spark);
		spark.loadXMLConfig("src/test/resources/extent-config.xml");

		Exception ex = null;
		try {
			int x = 1 / 0;
		} catch (Exception e) {
			ex = e;
		}

		extent.createTest("Text and Media Logs").createNode("DML").log(Status.PASS, "Text and Media",
				MediaEntityBuilder.createScreenCaptureFromPath("logo.png").build());

		extent.createTest("Exception and Media Logs").createNode("EML").log(Status.FAIL, ex,
				MediaEntityBuilder.createScreenCaptureFromPath("logo.png").build());

		extent.createTest("Text and Exception and Media Logs").createNode("DEML").log(Status.FAIL,
				"Text and Exception and Media", ex, MediaEntityBuilder.createScreenCaptureFromPath("logo.png").build());

		extent.flush();
	}
}
