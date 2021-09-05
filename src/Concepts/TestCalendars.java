package Concepts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCalendars {
	public static void main(String[] args) throws Exception {
     System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		driver.findElement(By.id("second_date_picker")).click();
		Calendar calendar = Calendar.getInstance();
		String targetDate = "25/Feb/2022";
		SimpleDateFormat Targetdateformat = new SimpleDateFormat("dd/MMM/yyyy");
		Date formatedDate;
		//1.Validate the user input date
		try {
			Targetdateformat.setLenient(false);
			formatedDate = Targetdateformat.parse(targetDate);
			calendar.setTime(formatedDate);
			int targetday = calendar.get(Calendar.DAY_OF_MONTH);
			int targetMonth = calendar.get(Calendar.MONTH);
			int targetyear = calendar.get(Calendar.YEAR);
			System.out.println(targetday+" "+targetMonth+" "+targetyear);//20 1 2021 here 1 is the index
			String ActualDate=driver.findElement(By.className("ui-datepicker-title")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(ActualDate));
			int ActualMonth = calendar.get(Calendar.MONTH);
			int Actualyear = calendar.get(Calendar.YEAR);
			System.out.println(ActualMonth+" "+Actualyear);
		//2.previous date	
			while(targetMonth<ActualMonth || targetyear<Actualyear) {
				driver.findElement(By.className("ui-datepicker-prev")).click();
				ActualDate=driver.findElement(By.className("ui-datepicker-title")).getText();
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(ActualDate));
				ActualMonth = calendar.get(Calendar.MONTH);
				Actualyear = calendar.get(Calendar.YEAR);
			}
	  //3.Future Date
			while(targetMonth>ActualMonth || targetyear>Actualyear) {//future date
				driver.findElement(By.className("ui-datepicker-next")).click();
				ActualDate=driver.findElement(By.className("ui-datepicker-title")).getText();
				calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(ActualDate));
				ActualMonth = calendar.get(Calendar.MONTH);
				Actualyear = calendar.get(Calendar.YEAR);
			}
		//4.current date below 
		driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td[not(contains(@class,'ui-datepicker-other-month'))]//a[text()="+targetday+"]")).click();
		} catch (ParseException e) {
			throw new Exception("you enterd invalid date, plz provide valid date");
		}
		
		//5.create a utility function for handling calendars in the flle "TestCalenderPREDEFINEDCODE"
	}
	
	
}
