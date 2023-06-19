package basefiles.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basefiles.abstractcomponents.AbstarctComponents;

public class ProductCatalogue extends AbstarctComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".col-lg-4")
	List<WebElement> products;
	By productBy = By.cssSelector(".col-lg-4");
	By addTocart = By.cssSelector(".btn:last-of-type");
	By toastMsg = By.cssSelector(".ngx-spinner-overlay");

	public List<WebElement> produstsList() {
		webElementToAppear(productBy);
		return products;

	}

	
	public void getAddToCart(String name) {
		WebElement x = getProductByName(name);
		x.findElement(addTocart).click();
		webElementToAppear(toastMsg);

	}


	public WebElement getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
