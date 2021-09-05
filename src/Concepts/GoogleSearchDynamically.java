package Concepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchDynamically {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		
		//using descendant
//		List <WebElement> li=driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		//following-sibling
//		List <WebElement> li=driver.findElements(By.xpath("//ul[@role='listbox']//li//following-sibling::div/div[@class='wM6W7d']"));
		List <WebElement> li=driver.findElements(By.xpath("		//ul[@role='listbox']//li//child::div[@class='wM6W7d']"));
		
		//ul[@role='listbox']//li//child::div[@class='wM6W7d']
		System.out.println("total no of suggestion in search box::="+li.size());
		for(int i=0;i<li.size();i++) {
			System.out.println(li.get(i).getText());
			if(li.get(i).getText().contains("selenium interview questions")) {
				li.get(i).click();
				break;
			}
		}
	}

}
