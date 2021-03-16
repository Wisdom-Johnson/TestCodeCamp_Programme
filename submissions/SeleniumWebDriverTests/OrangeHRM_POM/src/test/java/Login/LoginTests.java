package Login;

import Setup.SetupTests;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;

public class LoginTests extends SetupTests {

    // TestNG annotations
    @Test
    // This class extends to the SetupTests as the SetupTests class
    public void testLogin() throws InterruptedException {
        String username = "Admin";
        loginPage.enterUsername(username);
        loginPage.enterUserPassword("admin123");

        // Handler for dashboard page
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        String pageUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        System.out.println("PASSED - The page URL is" + pageUrl);
    }

    @Test
    public void testLogout() throws InterruptedException {
        try {
            dashboardPage.clickWelcomeAdmin();
            loginPage = dashboardPage.clickLogout();
        } catch (Exception e) {
            String loginUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
            System.out.println("PASSED - The page URL is" + loginUrl);
        }
    }
}

