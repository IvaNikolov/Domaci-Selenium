package d_07_02_2022Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	private WebDriver driver;

	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProductOne() {
		return driver.findElement(
				By.xpath("//li[contains(@class,'post-54')]/div/a[contains(@class,'woocommerce-loop-product__link')]"));
	}

	public WebElement getProduct(int ordinalNumberOfProduct) {
		List<WebElement> products = driver.findElements(By.xpath("//*[contains(@class,'products columns-3')]/li/a"));
		for (int i = 0; i < products.size(); i++) {
			if (i == ordinalNumberOfProduct) {
				products.get(i);
			}
		}
		return products.get(ordinalNumberOfProduct);
	}
}
