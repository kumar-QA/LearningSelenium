package Concepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HeadlessBrowserTesting {

	public static void main(String[] args) throws IOException {
	
		ChromeOptions option= new ChromeOptions();
		option.addArguments("Window-size=1400,800");
		option.addArguments("headless");
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Eclipse_workspace\\LearningSelenium\\src\\Concepts\\config.properties");
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
	
		String url=prop.getProperty("url");
		
		driver.get(url);
		
		
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath(prop.getProperty("mobileno_xpath"))).sendKeys(prop.getProperty("mobileno"));
	    System.out.println("url after execution"+url);
	}
}
