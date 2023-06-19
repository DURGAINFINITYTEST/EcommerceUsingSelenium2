package basefiles.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basefiles.abstractcomponents.AbstarctComponents;

public class BillingAddress extends AbstarctComponents {

	WebDriver driver;

	public BillingAddress(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkout;

	@FindBy(xpath = "//div/div[2]/input")
	WebElement cvvNumber;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryOption;
	@FindBy(css = ".btnn.action__submit.ng-star-inserted")
	WebElement conformOrder;

	public BillingAddress getBilligDetails(String cvv, String countrysDetails) {
		checkout.click();
		cvvNumber.sendKeys(cvv);
		countryOption.sendKeys(countrysDetails);
		BillingAddress billing = new BillingAddress(driver);
		return billing;

	}

	public void countrySeelection() {
		List<WebElement> countrys = driver.findElements(By.cssSelector(".ta-item.list-group-item.ng-star-inserted"));
		for (WebElement country : countrys) {
			if (country.getText().equalsIgnoreCase("india")) {
				country.click();
				break;
			}
		}

	}

	public void getConformOrder() {
		conformOrder.click();
	}
}
