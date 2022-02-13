package d_08_02_2022TP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
 
public class FormTest {
	private WebDriver driver;
	private FormPage fp;
	private WebDriverWait wait;
	@BeforeMethod

	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		fp = new FormPage(driver);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void FilltheForm() throws InterruptedException, IOException {
		driver.get("file:///C:/Users/Iva/Downloads/form%20(1).html");
		Thread.sleep(500);
		File file = new File("Files/FormData.xlsx");
		System.out.println(file.getAbsolutePath());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		SoftAssert sf = new SoftAssert();

		XSSFSheet sheet = wb.getSheet("form");
		for (int i = 1; i <= 6; i++) {

			String fullName = sheet.getRow(i).getCell(0).getStringCellValue();
			String gender = sheet.getRow(i).getCell(1).getStringCellValue();

			Date dateOfBirth = sheet.getRow(i).getCell(2).getDateCellValue();
			String email = sheet.getRow(i).getCell(3).getStringCellValue();
			String role = sheet.getRow(i).getCell(4).getStringCellValue();
			String waysOfDev = sheet.getRow(i).getCell(5).getStringCellValue();
			String comment = sheet.getRow(i).getCell(6).getStringCellValue();

			fp.getFullName().sendKeys(fullName);
			Thread.sleep(500);
			fp.getGenderRadioButton(gender).click();
			Thread.sleep(500);

			DateFormat df = new SimpleDateFormat();
			String dateOfBirth1 = df.format(dateOfBirth);

			fp.getDateOfBirth().sendKeys(dateOfBirth1);
			fp.getEmail().sendKeys(email);
			Thread.sleep(500);
			fp.getRole().selectByValue(role);
			Thread.sleep(500);
			fp.getCheckbox(waysOfDev).click();
			Thread.sleep(500);
			fp.getComment().sendKeys(comment);
			Thread.sleep(500);
			fp.getSubmitButton().click();

			sf.assertTrue(fp.savedSuccesfully(), "Nije snimljeno");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.invisibilityOfElementWithText(
					By.xpath("//*[@class='message-element poruka']"), "Sacuvani podaci."));

			driver.navigate().refresh();

		}

		sf.assertAll();
//		}
//		
//
//		@AfterMethod
//		public void after() {
//			driver.quit();
	}
}
