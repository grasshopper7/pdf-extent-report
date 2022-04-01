package tech.grasshopper.test;

import org.testng.annotations.Test;

public class FirstTest extends Base {

	@Test
	public void testOne() {
		System.out.println("Test One 11");
		extent.createTest("Log Levels", "Specify all log levels").pass("pass").fail("fail").skip("skip").warning("warn")
				.info("info").assignCategory("Category").assignAuthor("Author").assignDevice("Device");
	}

	@Test
	public void testTwo() {
		System.out.println("Test Two 11");
		extent.createTest("Test Heirarchy").pass("passing test").createNode("Child Test", "Child Test description")
				.pass("child pass test").createNode("Grand Child Test").pass("grand child pass test");

	}
}
