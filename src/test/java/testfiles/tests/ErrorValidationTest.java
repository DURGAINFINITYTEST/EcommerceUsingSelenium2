package testfiles.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import basefiles.pageobjects.LandingPage;
import testfiles.testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test
	public void ErrorValidationMethod() throws InterruptedException {
		page.loginApplication("njanamlk@gmail.com", "Chinna@57");
		Thread.sleep(3000);

	}
}
