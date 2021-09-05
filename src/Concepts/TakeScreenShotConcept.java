package Concepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TakeScreenShotConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//launch chrome
		driver.get("https://jqueryui.com/droppable/");//enter url
		
		driver.manage().window().maximize();//maxmize window
		driver.manage().deleteAllCookies();//delete all cookies
		

		//dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src,new File(""));
		try {
            FileUtils.copyFile(src, new File("E:\\Eclipse_workspace\\LearningSelenium\\src\\Concepts\\screen.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
