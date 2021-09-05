package Concepts;

//import java.util.Iterator;
//import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPop {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
//		driver.get("https://javascript.info/popup-windows");// enter url
		driver.manage().window().maximize();// maxmize window
		driver.manage().deleteAllCookies();// delete all cookies

		// dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("//a[@class='toolbar__button toolbar__button_run']")).click();
//		Set<String> ids=driver.getWindowHandles();
//		Iterator<String> itr=ids.iterator();
//		String parentWindowId=itr.next();
//		String childWindowId=itr.next();
//		driver.switchTo().window(childWindowId);
//		
//		//check switch window with title
//		
//		System.out.println("childWindow id"+driver.getTitle());
//		driver.close();
//		driver.switchTo().window(parentWindowId);
//		System.out.println("parent id:"+driver.getTitle());
		
		

	}

}
