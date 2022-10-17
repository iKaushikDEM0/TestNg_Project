package org.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void fillTextbox(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void pageTitle() throws IOException {
		String title = driver.getTitle();
		System.out.println(title);
		
	}

	public static void pageUrl() {
		String pageUrl = driver.getCurrentUrl();
		System.out.println(pageUrl);
	}

	public static void hold(int num) throws InterruptedException {
		Thread.sleep(num);
	}
	
	public static void home() {
		WebElement home = driver.findElement(By.xpath("//span[@class='visually-hidden']"));
		home.click();
	}
	
	public static void scrolldown(WebElement input) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", input);	
	}
	
	public static void screenShot1() throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File s = ss.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\User\\eclipse-workspace\\MavenProject\\Screenshots\\login.png");
		FileUtils.copyFile(s, d);
	}
	 
	public static void  mouseOver(WebElement target) {
		Actions a = new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	//datadriven table
	
	public static void getAllData() throws IOException {
		
		File f = new File("C:\\Users\\User\\eclipse-workspace\\MavenProject\\Excel\\Test Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook b = new XSSFWorkbook(fin);
		Sheet sh = b.getSheet("Sheet1");
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			Row r = sh.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				int type = c.getCellType();
				if (type == 1) {
					String name = c.getStringCellValue();
					System.out.println(name);
				}else if (DateUtil.isCellDateFormatted(c)) {
					java.util.Date da = c.getDateCellValue();

					SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
					String name = form.format(da);
					System.out.println(name);
				} else {
					double d = c.getNumericCellValue();
					long l = (long)d;
					String name = String.valueOf(l);
					System.out.println(name);
				}
			}
		}

	}
	public static String getExcelData(int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\User\\eclipse-workspace\\MavenProject\\Excel\\Test Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook b = new XSSFWorkbook(fin);
		Sheet sh = b.getSheet("Sheet1");
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String name = "";
		if (type == 1) {
			name = c.getStringCellValue();
		}else if (DateUtil.isCellDateFormatted(c)) {
			java.util.Date da = c.getDateCellValue();
			SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
			name = form.format(da);
		} 
		else {
			double d = c.getNumericCellValue();
			long l = (long)d;
			name = String.valueOf(l);
		}
		return name;
	}
	
	public static void excelStringInput(int rowNo, int cellNo, String value) throws IOException {
		File f = new File("C:\\Users\\User\\eclipse-workspace\\MavenProject\\Excel\\Test Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		Workbook b = new XSSFWorkbook(fin);
		Sheet sh = b.getSheet("Sheet1");
		Row r = sh.createRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(f);
		b.write(fout);
	}
	public static void excelLongInput(int rowNo, int cellNo, long value) throws IOException {
		File f = new File("C:\\Users\\User\\eclipse-workspace\\MavenProject\\Excel\\Test Data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		Workbook b = new XSSFWorkbook(fin);
		Sheet sh = b.getSheet("Sheet1");
		Row r = sh.createRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(f);
		b.write(fout);
	}
}


