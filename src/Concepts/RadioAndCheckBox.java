package Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckBox {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://nxtgenaiacademy.com/demo-site/");
		
//		radio button
//             driver.findElement(By.id("vfb-8-1")).click();	
             WebElement radio=driver.findElement(By.id("vfb-8-1"));
             radio.click();
             if(radio.isSelected()) {
            	 System.out.println("option is selected");
             }else {
            	 System.out.println("  not selected");
             }
            
//		Check box;
             WebElement option=driver.findElement(By.id("vfb-20-0"));
             option.click();
             if(option.isSelected()) {
            	 System.out.println("selenium webdriver option is selected");
             }else {
            	 System.out.println("check box not selected");
             }

	}

}
