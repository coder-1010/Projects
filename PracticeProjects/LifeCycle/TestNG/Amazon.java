package practiceProject.card6.two;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Amazon {
    public static RemoteWebDriver driver;
    public static String appURL = "http://www.amazon.in/";
    
    @BeforeClass
    public void setUp() throws MalformedURLException {
        System.out.println("*******************");
        System.setProperty("webdriver.chrome.driver", "/Users/shrutheebalakrishnan/Documents/chromedriver_mac_arm64");
        System.out.println("Opening browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test(priority = 0)
    public void testChrome() {
        driver.navigate().to(appURL);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("boat watches");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Amazon.in : boat watches","Page title doesn't match. Expected: Amazon.in : boat watches, Actual: " + pageTitle);
    }
    
    @Test(priority = 1)
    public void testCart() {
    	driver.navigate().to("https://www.amazon.in/boAt-Wave-Call-Dedicated-Multi-Sport/dp/B0B5B6PQCT/ref=sr_1_3?crid=151MI0PI09D7N&keywords=boat+watches&qid=1687416926&sprefix=boat+watche%2Caps%2C244&sr=8-3");
        WebElement web = driver.findElement(By.linkText("boAt Wave Call Smart Watch,Smart Talk with Advanced Dedicated Bluetooth Calling Chip, 1.69 HD Display with 550NITS & 70% Color Gamut, 150+ Watch Faces, Multi-Sport Modes,HR,SpO2, IP68(ActiveBlack)"));
        driver.navigate().to(web.getAttribute("href"));
        WebDriverWait waits = new WebDriverWait(driver, 10);
        WebElement addToCartButton = waits.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"));
		addToCartButton.click();
		String pageT = driver.getTitle();
		Assert.assertTrue(pageT.equalsIgnoreCase("boAt Wave Call Smart Watch, Smart Talk with Advanced Dedicated Bluetooth Calling Chip, 1.69 HD Display with 550 NITS & 70% Color Gamut, 150+ Watch Faces, Multi-Sport Modes,HR,SpO2, IP68(Active Black) :Amazon.in: Electronics"));
    }

    @AfterClass
    public void tearDown() {
	    	if (driver != null) {
	    		System.out.println("Closing browser..Chrome");
	    		driver.quit();
	    	}
    }
}