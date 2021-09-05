package Concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DynamicWebTableHandler {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://ui.cogmento.com/");
		driver.findElement(By.name("email")).sendKeys("bensonneal59@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Kumar@59");
		driver.findElement(By.xpath("//div[contains(@class,'ui fluid large blue submit button')]")).click();
		
		Actions actions = new Actions(driver);
		WebElement contactlink = driver.findElement(By.xpath("//*[contains(text(),'Contacts')]"));
		actions.moveToElement(contactlink);
		actions.click().moveByOffset(200, 220).build().perform();
		
		//Method 1
//		String before_xpath="//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr[";
//		String After_xpath=	"]/td[2]";	
//		for(int i=1;i<=3;i++) {	
//			Thread.sleep(2000);//realtime 
//			String name=driver.findElement(By.xpath(before_xpath+i+After_xpath)).getText();
//			System.out.println(name);
//			if(name.contains("test test")) {
//				driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr["+i+"]/td[2]")).click();
//			}
		//Method2
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'test test')]/parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'benson neal')]/parent::td//preceding-sibling::td/div[@class='ui fitted read-only checkbox']")).click();
		

		
	}

}
