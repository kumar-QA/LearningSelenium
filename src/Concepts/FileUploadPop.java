package Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		driver.findElement(By.id("myFile")).sendKeys("C:\\uploaded.html");
	}

}
