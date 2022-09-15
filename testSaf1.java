package UI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class testSaf1 {
public static String browser = "chrome";    // External configuration - xls, csv files
	public static WebDriver driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.chrome.driver","C:\\Users\\Dishonates\\Downloads\\browserdrivers\\chromedriver.exe");
if(browser.equals("Firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	}
else if(browser.equals("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();	
}
else if(browser.equals("edge")) {
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
}
		
		driver.get("http://www.ebay.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("smart watch");
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).click();
		driver.close();

	}

}
