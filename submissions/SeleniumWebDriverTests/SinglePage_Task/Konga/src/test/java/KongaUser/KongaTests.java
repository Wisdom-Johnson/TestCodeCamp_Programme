package KongaUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KongaTests
{
    //import selenium WebDriver
    private WebDriver driver;
    @BeforeClass
    public void setUp() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //input the website URL
        driver.get("https://www.konga.com/");
        //Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the browser
        driver.manage().window().fullscreen();
        //Get Page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void LoginTest() throws InterruptedException {
        //Click on the Login/Signup tab
        driver.findElement(By.linkText("Login / Signup")).click();
        //Click on the Email Address/ Phone number field and enter "johnsonwisdom60@gmail.com" or "08164328583"
        driver.findElement(By.id("username")).sendKeys("johnsonwisdom60@gmail.com");
        //Click on the Password field and input a valid password "Excellent101"
        driver.findElement(By.id("password")).sendKeys("Testcode5.0");
        //Click on the Login button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
        if (driver.getCurrentUrl().contains("https://www.konga.com/")) {
            System.out.println("PASSED - User has successfully logged in");
        } else {
            System.out.println("FAILED - The user was unable to login");
        }
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //On Categories click on "Computer and Accessories"
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[3]/div/a[2]")).click();
        Thread.sleep(10000);
        //Click on Laptops
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(10000);
        //Click on Apple MacBook
        driver.findElement(By.linkText("Apple MacBooks")).click();
        Thread.sleep(10000);
        //Add Macbook Laptop to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[2]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[4]/button")).click();
        Thread.sleep(10000);
        //Click on Cart
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/nav/div[2]/div/div/a[2]")).click();
        Thread.sleep(10000);
        //Click on Checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);
        //Change Address
        driver.findElement(By.linkText("Change Address")).click();
        Thread.sleep(10000);
        //Add Address
        driver.findElement(By.linkText("Add Address")).click();
        Thread.sleep(10000);
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Wick");
        driver.findElement(By.id("telephone")).sendKeys("08164328583");
        driver.findElement(By.id("street")).sendKeys("34, Ladipo Oluwole Street, Ikeja.");
        driver.findElement(By.id("landmark")).sendKeys("Access Bank");
        driver.findElement(By.id("city")).sendKeys("Ikeja");
        Select dropdown = new Select(driver.findElement(By.name("regionId")));
        dropdown.selectByVisibleText("Lagos");
        Thread.sleep(5000);
        dropdown = new Select(driver.findElement(By.name("areaId")));
        Thread.sleep(5000);
        dropdown.selectByVisibleText("Ikeja");
        //Click on Use this Address
        Thread.sleep(5000);
        //Click on Use this Address
        driver.findElement(By.linkText("Use this Address")).click();
        Thread.sleep(5000);
        //Click on Pay Now
        driver.findElement(By.linkText("selectPaymentMethod")).click();
        Thread.sleep(5000);
        //Click on Continue to Payment
        driver.findElement(By.name("placeOrder")).click();
        Thread.sleep(5000);
        //Click to select card payment type
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);
        //Click to close checkout modal frame
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        Thread.sleep(5000);
        //Click to input invalid card details
        driver.findElement(By.id("card-number"));
        Thread.sleep(5000);
        //Click on date field
        driver.findElement(By.id("expiry")).click();
        Thread.sleep(5000);
        //Click on CVV field
        driver.findElement(By.id("cvv")).click();
        Thread.sleep(5000);
        //Click on Pay Now
        driver.findElement(By.id("validateCardForm")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    // Quit the browser
    public void EndBrowser()
    {
        driver.quit();
    }
}









