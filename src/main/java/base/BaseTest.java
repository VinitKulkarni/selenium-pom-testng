package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;

    @BeforeMethod
    public void setup() {
    	WebDriverManager.chromedriver()
        .avoidBrowserDetection()
        .setup();

    	ChromeOptions options = new ChromeOptions();

    	options.addArguments("--headless");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");
    	options.addArguments("--disable-gpu");
    	options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
   

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
