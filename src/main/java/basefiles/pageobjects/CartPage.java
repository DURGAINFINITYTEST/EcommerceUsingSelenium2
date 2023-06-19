package basefiles.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basefiles.abstractcomponents.AbstarctComponents;

public class CartPage extends AbstarctComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartPage;
	@FindBy(css = ".cartSection h3")
	List<WebElement> valiadateProduct;

	public CartPage getCartPage() {
		cartPage.click();
		webElementToAppearanother(cartPage);
		CartPage cp = new CartPage(driver);
		return cp;

	}

	public void getValiadateProduct(String string) {
		// TODO Auto-generated method stub
		
	}

	
}
