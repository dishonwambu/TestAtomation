import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class TestDemo {

    public static String browser = "chrome"; // External configuration
    public static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            driver.get("http://www.ebay.com");
            driver.manage().window().maximize();

            // Wait until the search input is visible and enter text
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gh-ac']")));
            searchBox.sendKeys("smart watch");

            // Wait until the search button is clickable and click it
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='gh-btn']")));
            searchButton.click();

            // Wait for the search results page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("srp-river-results")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit(); // Properly close the browser
        }
    }
}
