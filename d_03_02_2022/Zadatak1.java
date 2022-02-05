package d_03_02_2022;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		1.Zadatak 
//		Napisati program koji:
//		Ucitava stranicu https://www.google.com/
//		Hvata body element sa stranicu i njemu setuje atribut 
//		style na vrednost �background: nekaBoja�
//		Skripta: arguments[0].style=�background: black�;
//		(Za vezbanje) Setuje prosledjenu boju:
//		Skripta: arguments[0].style=�background:� + arguments[1];
//		Boje za testiranje - red, green, blue, �
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement body = driver.findElement(By.xpath("//body"));

		js.executeScript("arguments[0].style='background:purple'", body);
	}

}
