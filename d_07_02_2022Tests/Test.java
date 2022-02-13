package d_07_02_2022Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import d_07_02_2022Pages.HomePage;
import d_07_02_2022Pages.KatalonPage;
import d_07_02_2022Pages.ProductPage;
import d_07_02_2022Pages.ShopPage;


public class Test {
	private WebDriver driver;
	private HomePage hp;
	private KatalonPage kp;
	private ProductPage pp;
	private ShopPage sp;
	
	
	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://cms.demo.katalon.com/");	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hp=new HomePage(driver);
		kp=new KatalonPage(driver);
		pp=new ProductPage(driver);
		sp=new ShopPage(driver);
	}
	@Test
	public void ProductCart() throws InterruptedException {
		driver.get("http://cms.demo.katalon.com/");
		Thread.sleep(1000);
		hp.getShopButton().click();
        sp.getProduct(0).click();
        pp.clearInsertInputQuantity("2");
        pp.getAddToCart().click();
        Thread.sleep(1000);
  //      Assert.assertTrue(pp.getMessage().contains("have been added to your cart"), "Nismo dodali proizvod");
         pp.getButton().click();
         Assert.assertEquals(kp.BrojProizvoda().size(),1);
         Assert.assertEquals(kp.getKolicina(),"2","Nema dovoljnog broja proizvoda");
         kp.getRemoveButton().click();
         Thread.sleep(1000);
          Assert.assertEquals(kp.getRemoveMessage(), "Korpa nije prazna");
	}

	}

