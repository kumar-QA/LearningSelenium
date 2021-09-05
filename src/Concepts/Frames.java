package Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		
//		driver.findElement(By.id("name")).sendKeys("prasannakumar");
//		Thread.sleep(3000);
//		
//		// switch to new Frame
//		driver.switchTo().frame(driver.findElement(By.id("frm1")));
//		Select course = new Select(driver.findElement(By.id("course")));
//		course.selectByVisibleText("Java");
//		Thread.sleep(3000);
//		// switch Back to normal page
//		driver.switchTo().defaultContent();
//		driver.findElement(By.id("name")).clear();
//		driver.findElement(By.id("name")).sendKeys("bensonNeal");
		
		/*-----------------------Nested Frames-------------------------------------*/		
		driver.findElement(By.id("name")).sendKeys("prasanna");//Main page 
		Thread.sleep(3000);
		//inside frame page(frm3) nested frame
		driver.switchTo().frame(driver.findElement(By.id("frm3")));
		driver.switchTo().frame(driver.findElement(By.id("frm1")));
		Select courses=new Select(driver.findElement(By.id("course")));
		courses.selectByVisibleText("Dot Net");
		//switch to frame3 page
		driver.switchTo().parentFrame();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("frame3 page returned");
		//switch to main page
		driver.switchTo().defaultContent();
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("main page");

	}

}
