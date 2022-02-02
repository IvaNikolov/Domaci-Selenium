package d_28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		Zadatak
//		Napisati program koji vrsi dodavanje 5 reda u tabelu. 
//		Maksimizirati prozor
//		Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//		Dodati red podataka - jedan red u jednoj iteraciji 
//		Kliknite na dugme Add New
//		Unesite name,departmant i phone (mogu da budu uvek iste vrednost)
//		Kliknite na zeleno Add dugme
//		Na kraju programa ugasite pretrazivac.
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate()
				.to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		Thread.sleep(2000);
		int redKojiSeDodaje = 4;
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.xpath("//*[@class='btn btn-info add-new']")).click();
		
	

		Scanner s = new Scanner(System.in);
		System.out.println("Unesite ime i prezime:");
		String imePrezime = s.nextLine();
		System.out.println("Unesite departmant:");
		String department = s.next();
		System.out.println("Unesite broj telefona:");
		String telefon = s.next();
		driver.findElement(By.id("name")).sendKeys(imePrezime);
		driver.findElement(By.id("department")).sendKeys(department);
		driver.findElement(By.id("phone")).sendKeys(telefon);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='table table-bordered']/tbody/tr["+redKojiSeDodaje+"]/td[4]/a")).click();
		redKojiSeDodaje++;
		}
		Thread.sleep(2000);
		driver.close();
	}

}
