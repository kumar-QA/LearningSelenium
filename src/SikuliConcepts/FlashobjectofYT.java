package SikuliConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FlashobjectofYT {

	public static void main(String[] args) throws FindFailed {
	
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.manage().window().maximize();// maxmize window
		driver.manage().deleteAllCookies();// delete all cookies
		driver.get("https://www.youtube.com/watch?v=s20GxxYUhfA");
		Screen s =new Screen();
		Pattern playImg=null;
		String filepath = "E:\\Eclipse_workspace\\LearningSelenium\\Resource\\";
		playImg=new Pattern(filepath+"playBtn.PNG");
		s.wait(playImg,2000);
		s.click(playImg);
		Pattern pauseimg=new Pattern("pausebtn.PNG");
		s.wait(pauseimg,2000);
		s.click(pauseimg);
		
		
	}
}
