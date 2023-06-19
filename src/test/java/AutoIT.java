import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.findElement(By.xpath("//a[@id='pickfiles']")).click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Users\\katak\\Downloads\\FileUpload.exe");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Convert to PDF']")).click();
		Thread.sleep(1000);

	}

}
 