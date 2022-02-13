package d_08_02_2022TP;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {
//	Zadatak
//	Za potrebe zadatka kreirati FormPage koji ima sve potrebne metode.
//		Zatim kreirati FormTest koji 
//	Ucitava form.html stranicu (form.html je u folderu za domaci skinite je i otvorite u chrome i iskopirajte url)
//	I popunjava formu koristeci FormData.xlsx fajl (u folderu je za domaci)
//	Postavite odgovarajuce waitere tako da se saceka sledeci unos podataka u formu nakon submitovanja
	private WebDriver driver;
	private WebDriverWait wait;

	public FormPage(WebDriver driver) {
		
		this.driver = driver;
		this.wait = wait;
	}
	public WebElement getFullName() {
		  return driver.findElement(By.id("first-name"));
	  }
	public WebElement getGenderRadioButton(String radioValue) {
		  return driver.findElement(By.xpath("//*[@name='gender'][@value='"+ radioValue +"']"));
}
	 public WebElement getDateOfBirth() {
		  return driver.findElement(By.id("dob"));
	  }
	  public WebElement getEmail() {
		  return driver.findElement(By.id("email"));
	  }
	  public Select getRole() {
		  Select se=new Select(driver.findElement(By.id("role")));

		  return se;
	  }

	public WebElement getCheckbox(String checkboxValue) {
		return driver.findElement(By.xpath("//*[@type='checkbox'][@value='" + checkboxValue + "']"));

	}

	public WebElement getComment() {
		return driver.findElement(By.id("comment"));
	}

	public WebElement getSubmitButton() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return driver.findElement(By.id("submit"));
	}

	public boolean savedSuccesfully() {

		boolean saved = true;

		List<WebElement> niz = driver.findElements(By.xpath("//div[@style='visibility: visible']"));
		if (niz.size() == 0) {
			saved = false;
		}
		return saved;
}}