package org.project;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Project1 extends BaseClass {
	@BeforeClass
	private void befCls() throws IOException, InterruptedException  {
		chromeBrowser();
		launchUrl("https://rootscollective.ph/");
		maxWindow();
		pageTitle();
		hold(3000);
	}
	@Test(priority=0, retryAnalyzer = Retry.class)
	
		private void login() throws InterruptedException, IOException  {
		WebElement account = driver.findElement(By.xpath("(//span[@class='site-nav__icon-label small--hide'])[1]"));
		account.click();
		hold(2000);
		WebElement dwn = driver.findElement(By.xpath("//h1[text()='Login']"));
		scrolldown(dwn);
		hold(2000);
		WebElement eMail = driver.findElement(By.id("CustomerEmail"));
		fillTextbox(eMail, getExcelData(0, 0));
		hold(2000);
		WebElement passWd = driver.findElement(By.id("CustomerPassword"));
		fillTextbox(passWd, getExcelData(1, 0));
		hold(2000);
		WebElement login = driver.findElement(By.xpath("(//button[@type='submit'])[6]"));
		login.click();
		
		//DataDriven Entry
		String s = "Login Successfull";
		excelStringInput(3, 0, s);
		System.out.println(s);
		hold(5000);
		screenShot1();
		System.out.println("TC:1"+Thread.currentThread().getId());
		
	}
	@Test(priority=1, retryAnalyzer = Retry.class)
	
	private void productNavigation1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://rootscollective.ph/");
		hold(2000);
		WebElement house = driver.findElement(By.xpath("(//li[@class='site-nav__item site-nav__expanded-item site-nav--has-dropdown site-nav--is-megamenu'])[3]"));
		house.click();
		hold(2000);
		WebElement f1 = driver.findElement(By.xpath("(//span[text()='Availability'])[1]"));
		scrolldown(f1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hold(2000);
		f1.click();
		WebElement select = driver.findElement(By.xpath("(//span[@class='tag__checkbox'])[1]"));
		hold(2000);
		select.click();
		hold(5000);
		WebElement f2 = driver.findElement(By.xpath("(//span[text()='Product type'])[1]"));
		scrolldown(f2);
		hold(2000);
		f2.click();
		hold(2000);
		WebElement f3 = driver.findElement(By.xpath("(//span[@class='tag__text'])[9]"));
		scrolldown(f3);
		hold(2000);
		f3.click();
		
		hold(2000);
		WebElement product1 = driver.findElement(By.xpath("(//div[@class='grid-product__color-image grid-product__color-image--39814706495597'])"));
		WebElement dest = driver.findElement(By.xpath("//div[text()='Woven Abre Tikog Grass Laptop Sleeve in Pintados']"));
		scrolldown(dest);
		
		hold(2000);
		//MouseOver Action
		
		WebElement mo1 = driver.findElement(By.xpath("(//span[@data-variant-id='39814706364525'])[1]"));
		mouseOver(mo1);
		hold(2000);
		
		WebElement mo2 = driver.findElement(By.xpath("(//span[@data-variant-id='39814706397293'])[1]"));
		mouseOver(mo2);
		hold(2000);

		WebElement mo3 = driver.findElement(By.xpath("(//span[@data-variant-id='39814706430061'])[1]"));
		mouseOver(mo3);
		hold(2000);

		WebElement mo4 = driver.findElement(By.xpath("(//span[@data-variant-id='39814706462829'])[1]"));
		mouseOver(mo4);
		hold(2000);
		
		product1.click();
		
		WebElement header = driver.findElement(By.xpath("(//h1[@class='h2 product-single__title'])[2]"));
		scrolldown(header);
		hold(3000);
		
		WebElement addToCart = driver.findElement(By.xpath("//button[@name='add']"));
		addToCart.click();
		hold(3000);
		System.out.println("TC:2"+Thread.currentThread().getId()  );

		
	}
	@Test(priority=2)
	
	private void productNavigation2() throws InterruptedException {
		driver.navigate().to("https://rootscollective.ph/");
		hold(3000);
		WebElement food= driver.findElement(By.xpath("(//a[@class='site-nav__link site-nav__link--underline site-nav__link--has-dropdown'])[2]"));
		food.click();
		hold(3000);
		WebElement f1 = driver.findElement(By.xpath("(//span[text()='Availability'])[1]"));
		scrolldown(f1);
		hold(3000);
		f1.click();
		hold(3000);
		WebElement f2 = driver.findElement(By.xpath("(//span[@class='tag__checkbox'])[1]"));
		f2.click();
		hold(3000);
		WebElement f3 = driver.findElement(By.xpath("(//span[text()='Product type'])[1]"));
		scrolldown(f3);
		hold(2000);
		f3.click();
		hold(2000);
		WebElement f4 = driver.findElement(By.xpath("(//span[text()='Chocolates'])[2]"));
		f4.click();
		hold(2000);
		WebElement chocolate = driver.findElement(By.xpath("//div[text()='Theo and Philo Chocolates Coconut Milk Chocolate-Covered Peanuts']"));
		chocolate.click();
		hold(2000);
		WebElement scroll = driver.findElement(By.xpath("//label[text()='90g']"));
		scrolldown(scroll);
		hold(2000);
		WebElement addToCart = driver.findElement(By.xpath("//button[@name='add']"));
		addToCart.click();
		hold(2000);
		driver.navigate().to("https://rootscollective.ph/");
		hold(2000);
	}
	@Test(priority=3, retryAnalyzer = Retry.class)
	private void checkOut() throws InterruptedException, IOException {
		WebElement cart = driver.findElement(By.xpath("(//span[@class='site-nav__icon-label small--hide'])[2]"));
		cart.click();
		hold(2000);
		WebElement checkout = driver.findElement(By.xpath("//button[@name='checkout']"));
		checkout.click();
		hold(2000);
		WebElement details = driver.findElement(By.xpath("(//div[@class='_1ip0g651 _1fragemo _1fragemqi _1fragemi2'])[1]"));
		String purchase = details.getText();
		excelStringInput(5, 0, purchase);
		System.out.println(purchase);
		hold(2000);
		driver.navigate().to("https://rootscollective.ph/");
		hold(2000);
		System.out.println("TC:3"+Thread.currentThread().getId()  );

	}
	@Test(priority=4, retryAnalyzer = Retry.class)
	private void logout() throws InterruptedException {
		WebElement account = driver.findElement(By.xpath("(//span[@class='site-nav__icon-label small--hide'])[1]"));
		account.click();
		hold(3000);
		WebElement logout = driver.findElement(By.xpath("//a[text()='Log out']"));
		logout.click();
		hold(5000);
		System.out.println("TC:4 "+Thread.currentThread().getId()  );

	}
	
	
	@AfterClass
	private void aftCls() throws InterruptedException {
		
		driver.quit();
	}
	}

