package d_04_02_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak2 {
//	Ucitajte stranicu (ako treba gasite onaj dijalog sto iskace)
//	Ukucajte za pretragu iphone
//	postavice za valutu eure
//	Sortirajte prema ceni da bude najjefinije prvo
//	Onda izvrsite proveru sortiranja kao sto je bilo za udemy
	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
	System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}

	@Test
	public void kupujemProdajem() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	driver.navigate().to("https://www.kupujemprodajem.com");

	wait.until(ExpectedConditions.elementToBeClickable(By.className("kpBoxCloseButton"))).click();
	driver.findElement(By.className("searchKeywordsInput")).sendKeys("Iphone");
	driver.findElement(By.className("searchKeywordsInput")).sendKeys(Keys.ENTER);

	wait.until(ExpectedConditions.elementToBeClickable(By.id("priceSecondSelection"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value = 'eur']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value='Primeni']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id = 'orderSecondSelection']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-text = 'Jeftinije']"))).click();

	driver.findElement(By.xpath("//*[@id = 'searchKeywordsInput']")).sendKeys(Keys.ENTER);
}}
