package Signin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    // import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
        public void setUp() throws InterruptedException {
        // Fetch the chromedriver_win32.zip file
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Launch the resources/chromedriver.exe file
        driver = new ChromeDriver();
        // Input the website URL
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        // Wait for the page to load in 5 seconds
        Thread.sleep(5000);
        //Maximize the the browser
        driver.manage().window().fullscreen();
        // Get page title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
        public void loginTest() throws InterruptedException {
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        // Click on the username field and input a valid username "performancetest"
        driver.findElement(By.id("username")).sendKeys("performancetest");
        // Click on the password field and input a valid password "admin123."
        driver.findElement(By.id("password")).sendKeys("admin123.");
        // Click on the Sign in button
        driver.findElement(By.xpath ("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        //Wait to see users logged in page
        Thread.sleep (10000);
        //Test to confirm user Logged in
        if(driver.getCurrentUrl ().contains ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")) {
            System.out.println ("PASSED - User has successfully logged in");
        }else{
            System.out.println ("FAILED - Login was unsuccessful");
        }
        Thread.sleep (20000); // Waiting to see logged in Page
    }

    @Test
        public void logoutTest() throws InterruptedException {
        // Click on the User profile
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button/p")).click();
        // Wait to ensure the drop-down list is displayed
        Thread.sleep (5000);
        //Click on the logout button
        driver.findElement (By.linkText ("Log Out")).click ();
        //Test to confirm user Logged out
        if(driver.getCurrentUrl ().contains ("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println ("PASSED - User has successfully logged out");
        }else{
            System.out.println ("FAILED - The user is still logged in");
        }
        //Waiting to see logged out Page
        Thread.sleep (5000);
    }

    @AfterTest
        public void tearDown(){
        driver.quit();
    }
}





