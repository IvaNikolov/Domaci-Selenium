package d_03_02_2022;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//2.Zadatak
//Napisati program koji:
//Ucitava stanicu https://www.wikipedia.org/
//Sa stranice sakuplja sve linkove (jezike) i svaki link otvara u novom prozoru pretrazivaca
//Svaki link potrebno je otvoriti u novom tabu.
//Skripta: window.open(arguments[0]);
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		List<WebElement> languages = driver.findElements(By.xpath("//*[@class, 'central-featured')]//a"));

		for (int i = 0; i < languages.size(); i++) {
			js.executeScript("window.open(arguments[0])", languages.get(i));
		}
	}

}
