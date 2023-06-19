package basefiles.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basefiles.abstractcomponents.AbstarctComponents;

public class LandingPage extends AbstarctComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userName;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	public void loginApplication(String name, String pswd) {
		userName.sendKeys(name);
		password.sendKeys(pswd);
		login.click();

	}

	public LandingPage goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage page = new LandingPage(driver);
		return page;

	}

}
