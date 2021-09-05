package Concepts;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	/*   ------------------------ Single select in dropdown button----------------------	
		driver.get("https://www.jquery-az.com/bootstrap4/demo.php?ex=79.0_1");
		driver.findElement(By.id("btnDropdownDemo")).click();
		List <WebElement> links= driver.findElements(By.xpath("//div[@class='dropdown-menu show']/a"));
		
		for(WebElement li:links) {
			String linksList=li.getText();
			if(linksList.equals("CSS")) {
				li.click();
			}
		}			
	*/
		
	//----------------------------multiSelect bootstrap dropdown button--------
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		WebElement dropdownBtn =driver.findElement(By.xpath("//button[@type='button' and @data-toggle='dropdown']"));
		dropdownBtn.click();
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]/li[not(@class='multiselect-item multiselect-group')]/a/label"));
		for(WebElement option:list) {
			WebElement optionChk=option.findElement(By.tagName("input"));
			String linktext=option.getText();
			if(linktext.equals("Bootstrap"))
				option.click();
			
			if(linktext.equals("Java")) 
				optionChk.click();	
			if(linktext.equals("CSS") && option.findElement(By.tagName("input")).isSelected()){
				optionChk.click();
				}
		}
		if(Boolean.valueOf(dropdownBtn.getAttribute("aria-expanded")))
			dropdownBtn.click();
	}

}
