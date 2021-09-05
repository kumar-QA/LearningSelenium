package Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/demo-site/");
		String Title=driver.getTitle();
		if(Title.equals("Demo Site – Registration Form – NxtGen A.I Academy")) {System.out.println("correct title");}
		else {System.out.println("wrong Title");}
		
		//Enter details in registeration form using different locators
		// preferable way 1.id,2.xpath,3.name, for links 1.linktext not partiallinltText,4.cssSelector,
		//2.xpath
		
		driver.findElement(By.xpath("//*[@id=\"vfb-5\"]")).sendKeys("p");
		driver.findElement(By.xpath("//*[@id=\"vfb-7\"]")).sendKeys("kumar");
		
		//1.id
//		
//		driver.findElement(By.id("vfb-13-address")).sendKeys("Hno:13/2424");
//		driver.findElement(By.id("vfb-13-address-2")).sendKeys("xyz Street");
//		driver.findElement(By.id("vfb-14")).sendKeys("xyz@gmail.com");
//		
//		//3.name
//		driver.findElement(By.name("vfb-13[city]")).sendKeys("abc");
//		
//		//4.cssSelector
//		driver.findElement(By.cssSelector("#vfb-13-state")).sendKeys("x state");
//		/*
//		   if id we use --- #{id}
//		   if class we use .{class}
//		*/
//		
//		//linkText
//		driver.findElement(By.linkText("PYTHON FOR DATA SCIENCE")).click();
		
		//classname is not preferable because class name is common for multiple html element so ..
	}

}
