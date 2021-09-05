package Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/demo-site/");
		
		//Handle drop down box --we use select class
		Select sel=new Select(driver.findElement(By.id("vfb-13-country")));
		sel.selectByVisibleText("India");
	}

}
