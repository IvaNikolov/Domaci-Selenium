package d_31_01_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		1.Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI KORISCENJEM PETLJE)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		int brojElemenata = driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button")).size();
		//odozdo
		for (int i = 4; i >= 0; i--) {
			driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button")).get(i).click();
			int brojElemenataNakonBrisanja = driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button"))
					.size();
			if (brojElemenata - 1 == brojElemenataNakonBrisanja) {
				brojElemenata--;
				System.out.println("Element je obrisan");
			}
			Thread.sleep(2000);
		}
		driver.close();
	//odozgo		
		for (int i = 5; i >= 0; i++) {
			driver.findElement(By.className("close")).click();
			int brojElemenataNakonBrisanja = driver.findElements(By.xpath("//*[contains(@class, 'col-md-12')]//button"))
				.size();
		if (brojElemenata - 1 == brojElemenataNakonBrisanja) {
				brojElemenata--;
			System.out.println("Element je obrisan");
			}
			Thread.sleep(3000);
		}
		driver.close();
		
	}

}
