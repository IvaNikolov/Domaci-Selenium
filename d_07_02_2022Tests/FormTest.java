package d_07_02_2022Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d_07_02_2022Pages.FormPage;

public class FormTest {
	private WebDriver driver;
	private FormPage fp;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		fp = new FormPage(driver);

	}

	@Test
	public void PopunitiFormu() throws InterruptedException {
		driver.get("file:///C:/Users/Iva/Downloads/form.html");
		Thread.sleep(500);
		fp.getFullName().sendKeys("Iva Nikolov");
		fp.getGenderRadioButton("female").click();
		fp.getDateOfBirth().sendKeys("07.11.1986");
		fp.getEmail().sendKeys("ivanikolov86@gmail.com");
		fp.getRole().selectByValue("QA");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("comment")));
		Thread.sleep(1000);
		fp.getCheckbox(" ").click();
		fp.getComment().sendKeys("No comment");
		fp.getSubmitButton().click();
		Assert.assertTrue(fp.savedSuccesfully(), "Nije uspesno snimljeno");
		
	}
}


