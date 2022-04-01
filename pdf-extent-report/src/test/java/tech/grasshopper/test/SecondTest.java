package tech.grasshopper.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SecondTest extends Base {

	@Test
	public void testOne() {
		System.out.println("Test One 22");
		Exception ex = null;
		try {
			int x = 1 / 0;
		} catch (Exception e) {
			ex = e;
		}
		extent.createTest("Exception Test",
				"This is an Exception extent Test. This is an Exception extent Test. This is an Exception extent Test.")
				.fail(ex);
	}

	@Test
	public void testTwo() {
		System.out.println("Test Two 22");
		extent.createTest("Generated Log").generateLog(Status.SKIP, "This is a generated log.");

		extent.createTest("Log And Generated").generateLog(Status.WARNING, "This is a combination with generated log.")
				.warning("This is a combination with log.");

	}
}
