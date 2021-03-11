package User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    // Import Selenium WebDriver
    private WebDriver driver;
    // Functions before the test commences
    @BeforeClass
    public void setUp() throws InterruptedException {
        // Fetch the ChromeDriver file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Launch the ChromeDriver
        driver = new ChromeDriver();
        // Input the website URL
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        // Wait for the page to load
        Thread.sleep(5000);
        // Maximize the browser
        driver.manage().window().fullscreen();
        // Get the page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Test for the Login page
    @Test
    public void loginTest() throws InterruptedException {
        //Locate the username field. Use your own Valid username "performancetest"
        driver.findElement(By.id("username")).sendKeys("performancetest");
        //Locate the password field. Use your own Valid password "admin123."
        driver.findElement(By.id("password")).sendKeys("admin123.");
        // Click on the Sign in/ Login button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        // Wait for the page to load
        Thread.sleep(5000);
        // Test to confirm user logged in
        if(driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed\"")){
            System.out.println("PASSED - User has successfully logged in");
        }else{
            System.out.println("FAILED - User was unable log in");
        }
        // Waiting to see logged in page
        Thread.sleep(5000);
    }
    // Test for the Logout page
    @Test
    public void logoutTest() throws InterruptedException {
        //Click on the arrow button that has the logout menu on the list
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        // Wait to ensure the drop-down list is displayed
        Thread.sleep(5000);
        // Click the Logout button
        driver.findElement(By.linkText("Log Out")).click();
        // Test to confirm user logged out
        if(driver.getCurrentUrl ().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println ("PASSED - User has successfully logged out");
        }else{
            System.out.println ("FAILED - The user is still logged in");
        }
        /* Waiting to see logged out Page */
        Thread.sleep (5000);
    }
    // Quit the browser
    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }
}
