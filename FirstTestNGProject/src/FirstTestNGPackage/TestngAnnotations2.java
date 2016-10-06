package FirstTestNGPackage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestngAnnotations2 {
	// test case 1
	@Test
	public void testCase1() {
		System.out.println("in test case 1");
	}

	// test case 2
	@Test
	public void testCase2() {
		System.out.println("in test case 2");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("in beforeMethod2");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("in afterMethod2");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("in beforeClass2");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("in afterClass2");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("in beforeTest2");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("in afterTest2");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in beforeSuite2");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in afterSuite2");
	}

}