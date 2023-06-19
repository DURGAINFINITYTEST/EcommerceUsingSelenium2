package testfiles.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import basefiles.pageobjects.LandingPage;

public class BaseTest {

	public Properties pro;
	public FileInputStream fis;
	public WebDriver driver;
	public LandingPage page;

	public WebDriver initializeDriverFirst() throws IOException {
		pro = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir")+"src\\main\\java\\basefiles\\resources\\Golbal.properties");
		pro.load(fis);
		String s = pro.getProperty("browser");

		if (s.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\katak\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (s.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\katak\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplicationFirst() throws IOException {

		driver = initializeDriverFirst();
		page = new LandingPage(driver);
		page.goTo();
		return page;

	}

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		driver.close();
	}

	@Test
	public String getScreenshot(String TestCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File desFile = new File(System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png");
		FileUtils.copyFile(srcFile, desFile);
		return System.getProperty("user.dir") + "//reports//" + TestCaseName + ".png";

	}
}
