package Concepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DiffBrowserLaunch {

	public static void main(String[] args) {
		// Google chrome

				System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
				WebDriver driver =new ChromeDriver();
				driver.get("https:\\www.facebook.com");
				String title=driver.getTitle();
				if(title.equals("Facebook – log in or sign up")) {System.out.println("title Verified");}else {System.out.println("Incorrect title");}
				System.out.println(driver.getCurrentUrl());
				driver.quit();
//				driver.close();
				

		// OperaBrowser
//
//		System.setProperty("webdriver.opera.driver", "C:\\BrowserDrivers\\operadriver.exe");
//		WebDriver opDriver = new OperaDriver();
//		opDriver.get("https:\\www.opera.com");
//		opDriver.close();

		// FireFox
//		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
//		WebDriver FFDriver = new FirefoxDriver();
//		FFDriver.get("https:\\www.firefox.com");
//		FFDriver.close();

	}

}
