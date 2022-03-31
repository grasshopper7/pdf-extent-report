package tech.grasshopper.reporter;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TESTMarkupReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extent = new ExtentReports();
		extent.setMediaResolverPath(new String[] { "images" });

		ExtentPDFReporter pdf = new ExtentPDFReporter("reports/TESTMarkupPDFReport.pdf");
		extent.attachReporter(pdf);
		// pdf.loadJSONConfig(new File("src/test/resources/pdf-config.json"));

		ExtentSparkReporter spark = new ExtentSparkReporter("reports/TESTMarkupSparkReport.html");
		extent.attachReporter(spark);
		spark.loadXMLConfig("src/test/resources/extent-config.xml");

		extent.createTest("Label").generateLog(Status.INFO, MarkupHelper.createLabel(
				"This is a sample label text display. This is a sample label text display. This is a sample an label text display.",
				ExtentColor.ORANGE));

		String[][] data1 = { { "Heading One", "Heading Two", "Heading Three", "Heading Four" },
				{ "Row 1 Column 1", "Row 1 Column 2", "Row 1 Column 3", "Row 1 Column 4" },
				{ "Row 2 Column 1", "Row 2 Column 2", "Row 2 Column 3", "Row 2 Column 4" },
				{ "Row 3 Column 1", "Row 3 Column 2", "Row 3 Column 3", "Row 3 Column 4" },
				{ "Row 4 Column 1", "Row 4 Column 2", "Row 4 Column 3", "Row 4 Column 4" } };

		// String[][] data1 = {{}};

		extent.createTest("Table Column Fit").pass(MarkupHelper.createTable(data1));

		String[][] data2 = {
				{ "Heading One", "Heading Two", "Heading Three", "Heading Four", "Heading Five", "Heading Six" },
				{ "Row 1 Column 1", "Row 1 Column 2", "Row 1 Column 3", "Row 1 Column 4", "Row 1 Column 5",
						"Row 1 Column 6" },
				{ "Row 2 Column 1", "Row 2 Column 2", "Row 2 Column 3", "Row 2 Column 4", "Row 2 Column 5",
						"Row 2 Column 6" } };

		extent.createTest("Table Column Extra").createNode("Indent").info(MarkupHelper.createTable(data2));

		Map<String, String> ullidata = new LinkedHashMap<>();
		ullidata.put("First",
				"List Item Number 1 List Item Number 1 List Item Number 1 List Item no 1 List Item no 1 List Item Number 1");
		ullidata.put("Second", "List Item Number 2");
		ullidata.put("Third", " List Item Number 3");
		ullidata.put("Fourth", " List Item Number 4");

		extent.createTest("Ordered List").createNode("Indent List").createNode("Indent List Sec")
				.generateLog(Status.INFO, MarkupHelper.createOrderedList(ullidata));

		extent.createTest("Unordered List").generateLog(Status.WARNING, MarkupHelper.createUnorderedList(ullidata));

		String JSON_CODE = "{ name: { first: \"John\", last:\"Jane\" }, age: 31, city: \"New York\", borough: \"Staten Island\" }";

		String XML_CODE = "<food>\n"
				+ "    <name>Belgian Waffles</name>\n    <price>$5.95</price>\n    <calories>650</calories>\n</food>";

		extent.createTest("JSON Code Block").createNode("Indent List").createNode("Indent List Sec")
				.fail(MarkupHelper.createCodeBlock(JSON_CODE, CodeLanguage.JSON));

		extent.createTest("XML Code Block").createNode("Indent List Sec")
				.pass(MarkupHelper.createCodeBlock(XML_CODE, CodeLanguage.XML));

		extent.createTest("Code Blocks").skip(MarkupHelper.createCodeBlock(XML_CODE, JSON_CODE, XML_CODE));

		extent.createTest("Generted JSON Code Block")
				.generateLog(Status.INFO, MarkupHelper.createCodeBlock(JSON_CODE, CodeLanguage.JSON)).createNode("GCB")
				.generateLog(Status.INFO, MarkupHelper.createCodeBlock(JSON_CODE, CodeLanguage.JSON));

		extent.createTest("Other medias").createNode("Test Media")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("logo.png").build())
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("json.json").build());

		extent.flush();
	}
}
