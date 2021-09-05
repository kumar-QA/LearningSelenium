package Concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class customizedXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://jqueryui.com/droppable/");//enter url
		
		driver.manage().window().maximize();//maxmize window
		driver.manage().deleteAllCookies();//delete all cookies
		

		//dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*------------Customized xpaths-------------------*/
		
//1.normal way		
	     driver.findElement(By.xpath("//input[@class='ds-input']")).sendKeys("menu");
	     driver.findElement(By.xpath("//input[@name='s']")).sendKeys("menu");
//2.contains() when to use contains {if id`s are not constant ex:reload page id changes}
//	     
//	     driver.findElement(By.xpath("//input[contains(@class,'ds-input')]")).sendKeys("menu");
//	     driver.findElement(By.xpath("//input[contains(@name,'s')]")).sendKeys("menu");
	     
//3.starts-with();{if id`s are changing like...id=test_1234,id=test_231,id=test_456}
	     
//	     driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("menu");//use like these
//		 driver.findElement(By.xpath("//input[starts-with(@name,'s')]")).sendKeys("menu");
		
//4.ends-with();{id id are like...id=1234_test_test,id=3142_test_test,id=345_test-test}
//		 driver.findElement(By.xpath("//input[ends-with(@id,'_test_test')]")).sendKeys("menu");
		 
//5.for links text()inside contain()method
		 driver.findElement(By.xpath("//a[contains(text(),'Draggable')]")).click();
	}

}
