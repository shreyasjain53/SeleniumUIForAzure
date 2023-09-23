package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AzureSampleTest {

	WebDriver driver;
	String url = "https://shreyasjain.azurewebsites.net/webapp/";
	String title = "Shreyas Jain";
	String pageHeaderText = "Shreyas Kumar P";

	@BeforeClass
	public void browserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void urLValidation() {
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(), url);
	}

	@Test(priority = 2)
	public void titleValidation() {
		Assert.assertEquals(driver.getTitle(), title);
	}

	@Test(priority = 3)
	public void contentValidation() {
		String pageText = driver
				.findElement(By.xpath("//div[@class='container-fluid p-2 bg-primary text-white text-center']"))
				.getText();
		Assert.assertEquals(pageText, pageHeaderText);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
