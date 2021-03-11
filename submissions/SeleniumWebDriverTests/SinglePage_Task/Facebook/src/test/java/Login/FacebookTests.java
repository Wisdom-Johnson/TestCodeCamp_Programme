package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookTests {
    // Import Selenium WebDriver
    private WebDriver driver;
    // Functions before the test commences
    @BeforeClass
    public void NewSetUp() throws InterruptedException {
        // Fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Launch the Chrome Driver
        driver = new ChromeDriver();
        // Input the website URL
        driver.get("https://web.facebook.com/?_rdc=1&_rdr");
        // Wait for the page to load
        Thread.sleep(5000);
        // Maximize the browser
        driver.manage().window().fullscreen();
        // Get page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Test the Login page
    @Test
    public void NewLogin() throws InterruptedException {
        // Click on the Email or phone number field and input a valid data "08164328583"
        driver.findElement(By.name("email")).sendKeys(String.valueOf("08164328583"));
        // Click on the password field and input a valid password "Uzoegbu100"
        driver.findElement(By.name("pass")).sendKeys("Uzoegbu100");
        // Click on the Login button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        //Wait to see users logged in page
        Thread.sleep (10000);
        //Test to confirm user Logged in
        if(driver.getCurrentUrl ().contains("https://web.facebook.com/")) {
            System.out.println ("PASSED - User has successfully logged in");
        }else{
            System.out.println ("FAILED - Login was unsuccessful");
        }
        // Waiting to see logged in Page
        Thread.sleep (10000);
    }
    // Quit the browser
    @AfterTest
    public void EndGame(){
        driver.quit();
    }
}
