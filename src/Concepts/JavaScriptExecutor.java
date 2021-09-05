package Concepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExecutor {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// launch chrome
//		driver.get("https://opensource-demo.orangehrmlive.com");// enter url

		driver.manage().window().maximize();// Maximise window
		driver.manage().deleteAllCookies();// delete all cookies

		// dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
//		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
////		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
//	     WebElement login=driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
//	     WebElement link=driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]"));
//	     flash(login,driver);
//	     drawBorder(login,driver);
//	     //take a screenshot
//	     File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	     FileUtils.copyFile(src,new File("E:\\Eclipse_workspace\\LearningSelenium\\src\\Concepts\\bug.png"));
//	     //genertae alert
////	     generateAlert(driver,"ther is an issue in login button in login page");
//	     //click element using js
//	     clickElementByJS(login,driver);
//	     //referesh browser using selenium
////	     driver.navigate().refresh();
//	     //refersh browser using js
////	     RefereshBrowser(driver);
//	     //get title using js executor
//	    System.out.println(getTitle(driver));
//	    //innerText of page
//	    System.out.println(getPageInnerText(driver));
	    
	    driver.get("https://classic.freecrm.com/index.html");
	  //scrollpage down in js
	    
	    WebElement link=driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
	    
//	    scrollPageDown(driver);
	    
	    scrollIntoView(link,driver);
	   
	}
	

	public static void flash(WebElement element,WebDriver driver) {
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	public static void changeColor(String color,WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		try {Thread.sleep(20);}
		catch(InterruptedException e){}
	}
	
	public static void drawBorder(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
				js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
				
	}
	public static void clickElementByJS(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", element);
	}
	public static void RefereshBrowser(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitle(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String pageinnertext=js.executeScript("return document.documentElement.innerText;").toString();
		return pageinnertext;
	}
//	public static void scrollPageDown(WebDriver driver) throws InterruptedException {
//		JavascriptExecutor js=((JavascriptExecutor)driver);
//		  while(true){
//	            Long height=(Long) js.executeScript("return document.body.scrollHeight");
//	            System.out.println(height);
//	            Thread.sleep(1000);
//	            driver.findElement(By.tagName("body")).sendKeys(Keys.END);        
//
//	            if (height==2870)
//	            {
//	                break;
//	            }
//		  }
//	}
	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,2500)");
		System.out.println("Scrolled down");
	}
	public static void scrollIntoView(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		System.out.println("scrolled into view");
	}
	
}
