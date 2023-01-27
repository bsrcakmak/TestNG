package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

    @Test
    public void openSourceLogin() {

        // 1. adim: Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        // 2. adim: Page Object'i olustur, hangi page'e ihtiyacimiz varsa
        OpenSourcePage openSourcePage = new OpenSourcePage();

        // 2. adim: Bu object'i kullanarak o siniftaki object'lere ulas
        openSourcePage.username.sendKeys("Admin");
        openSourcePage.password.sendKeys("admin123");
        openSourcePage.submitButton.click();
        // Burda OOP Consept kullaniyoruz

        // 4. adim: Assertion yap
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

        // 5. adim: Close driver
        Driver.closeDriver();
    }
}
