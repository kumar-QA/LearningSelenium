package Concepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadPropertiesOfFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Eclipse_workspace\\LearningSelenium\\src\\Concepts\\config.properties");
		prop.load(fis);
		
		if (prop.getProperty("browsername").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (prop.getProperty("browsername").equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (prop.getProperty("browsername").equals("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\BrowserDrivers\\operadriver.exe");
			driver = new OperaDriver();
		}
		
		String url=prop.getProperty("url");
		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath(prop.getProperty("mobileno_xpath"))).sendKeys(prop.getProperty("mobileno"));
		
		Select select = new Select(driver.findElement(By.xpath(prop.getProperty("country_xpath"))));
		select.selectByVisibleText(prop.getProperty("country"));
				
	}

}
