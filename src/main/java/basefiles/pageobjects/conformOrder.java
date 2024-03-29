package basefiles.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basefiles.abstractcomponents.AbstarctComponents;

public class conformOrder extends AbstarctComponents {

	WebDriver driver;

	public conformOrder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".hero-primary")
	WebElement acatualResult;

	public String getConfromOrder() {
		return acatualResult.getText();

	}

}
