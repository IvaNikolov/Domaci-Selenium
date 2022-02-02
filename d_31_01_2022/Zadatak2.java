package d_31_01_2022;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		2.Zadatak
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//		Bira proizvoljan Country, State i City
//		Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//		I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//		Izabrerit Country, State i City tako da imate podatke da selektujete!
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.navigate().to("https://geodata.solutions/");
		
		Select dropdownCountry= new Select(driver.findElement(By.name("country")));
		Select dropdownState= new Select(driver.findElement(By.name("state")));
		Select dropdownCity= new Select(driver.findElement(By.name("city")));
		
		dropdownCountry.selectByVisibleText("Argentina");
		Thread.sleep(1000);
		dropdownState.selectByVisibleText("Buenos Aires");
		Thread.sleep(1000);
		dropdownCity.selectByVisibleText("Pinamar");
		Thread.sleep(1000);
		driver.close();
		
	}

}
