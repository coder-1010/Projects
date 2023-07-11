import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.*;

public class Form {
    public static void main(String[] args) throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver", "/Users/shrutheebalakrishnan/Documents/chromedriver_mac_arm64");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://demo.automationtesting.in/Register.html";
        driver.get(baseUrl);
        
        WebElement firstname = driver.findElement(By.cssSelector("[ng-model='FirstName']"));
        // Get the WebElement corresponding to the Password Field
        WebElement lastname = driver.findElement(By.cssSelector("[ng-model='LastName']"));
        WebElement address = driver.findElement(By.cssSelector("[ng-model='Adress']"));
        WebElement email = driver.findElement(By.cssSelector("[ng-model='EmailAdress']"));
        WebElement phone = driver.findElement(By.cssSelector("[ng-model='Phone']"));

        driver.findElement(By.id("checkbox2")).click();
        WebElement gender = driver.findElement(By.cssSelector("[ng-model='radiovalue'][value='Fe,ale']"));
        WebElement skill = driver.findElement(By.cssSelector("[ng-model='Skill']option[value='Adobe InDesign']"));
        WebElement scountry = driver.findElement(By.cssSelector("[id='country']option[value='India']"));
        WebElement password = driver.findElement(By.cssSelector("[ng-model='Password']"));
        WebElement cpassword = driver.findElement(By.cssSelector("[ng-model='CPassword']"));
        WebElement year = driver.findElement(By.cssSelector("[ng-model='yearbox']option[value='2000']"));
        WebElement month = driver.findElement(By.cssSelector("[ng-model='monthbox']option[value='January']"));
        WebElement day = driver.findElement(By.cssSelector("[ng-model='daybox']option[value='1']"));
        
        firstname.sendKeys("shruthee");
        Thread.sleep(1000);
        lastname.sendKeys("b");
        Thread.sleep(1000);
        address.sendKeys("zaggle dwaraka layout");
        Thread.sleep(1000);
        email.sendKeys("shruthee@zaggle.in");
        Thread.sleep(1000);
        driver.findElement(By.id("Button1")).click();
        Thread.sleep(1000);
        
        firstname = driver.findElement(By.cssSelector("[ng-model='FirstName']"));
        
        lastname = driver.findElement(By.cssSelector("[ng-model='LastName']"));
        address = driver.findElement(By.cssSelector("[ng-model='Adress']"));
        email = driver.findElement(By.cssSelector("[ng-model='EmailAdress']"));
        phone = driver.findElement(By.cssSelector("[ng-model='Phone']"));
        driver.findElement(By.id("checkbox2")).click();
        gender = driver.findElement(By.cssSelector("[ng-model='radiovalue'][value='Female']"));
        WebElement multiSelectField = driver.findElement(By.id("msdd"));
        multiSelectField.click();
        List<WebElement> options = driver.findElements(By.cssSelector("ul.ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content.ui-corner-all li"));
        List<String> languagesToSelect = Arrays.asList("English", "French", "German");
        for (WebElement option : options) {
            String language = option.getText();
            if (languagesToSelect.contains(language)) {
                option.click();
            }
        }
        
        skill = driver.findElement(By.cssSelector("[ng-model='Skill']option[value='Adobe InDesign']"));
        scountry = driver.findElement(By.cssSelector("[id='country']option[value='India']"));
        password = driver.findElement(By.cssSelector("[ng-model='Password']"));
        cpassword = driver.findElement(By.cssSelector("[ng-model='CPassword']"));
        year = driver.findElement(By.cssSelector("[ng-model='yearbox']option[value='2000']"));
        month = driver.findElement(By.cssSelector("[ng-model='monthbox']option[value='January']"));
        day = driver.findElement(By.cssSelector("[ng-model='daybox']option[value='1']"));
        		        
        firstname.sendKeys("shruthee");
        Thread.sleep(1000);
        lastname.sendKeys("b");
        Thread.sleep(1000);
        address.sendKeys("zaggle dwaraka layout");
        Thread.sleep(1000);
        email.sendKeys("shruthee@zaggle.in");
        Thread.sleep(1000);
        phone.sendKeys("9876543210");
        Thread.sleep(1000);
        gender.click();
        Thread.sleep(1000);
        skill.click();
        Thread.sleep(1000);
        scountry.click();
        Thread.sleep(1000);
        password.sendKeys("zaggle");
        Thread.sleep(1000);
        cpassword.sendKeys("zaggle");
        Thread.sleep(1000);
        year.click();
        Thread.sleep(1000);
        month.click();
        Thread.sleep(1000);
        day.click();
        Thread.sleep(1000);
        driver.findElement(By.id("submitbtn")).click();
        Thread.sleep(1000);
        System.out.println("Text Field Set");
    }
}
