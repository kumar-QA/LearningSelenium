package Concepts;


import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElementsconcept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://jqueryui.com/droppable/");// enter url

		driver.manage().window().maximize();// Maximise window
		driver.manage().deleteAllCookies();// delete all cookies

		// dynamic timeout --if loaded remaing time is ignored
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// get the total links in a webpage and display its text

		List<WebElement> linklist = driver.findElements(By.tagName("a"));

		System.out.println(linklist.size());

		/*------------Iterator----------------*/

		Iterator<WebElement> itr = linklist.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

		/*-----------listIterator------------------*/

		ListIterator<WebElement> li = linklist.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next().getText());
		}
		/*-----------for loop-------------------*/
		for (int i = 0; i < linklist.size(); i++) {
			System.out.println(linklist.get(i).getText());
		}
		/*--------------------for Each-----------*/
		for (WebElement elements : linklist) {
			System.out.println(elements.getText());
		}
	}

}
