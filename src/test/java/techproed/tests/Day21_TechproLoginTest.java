package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.Driver;

public class Day21_TechproLoginTest {

    @Test
    public void loginTest(){
        Driver.getDriver().get("https://testcenter.techproeducation.com/index.php?page=form-authentication");
        TechproLoginPage techproLoginPage = new TechproLoginPage();
        TechproHomePage techproHomePage = new TechproHomePage();
        techproLoginPage.username.sendKeys("techproed");
        techproLoginPage.password.sendKeys("SuperSecretPassword");
        techproLoginPage.submitButton.click();

        // Assertion
        // Login yapildi, Driver su anda HomePage de
        Assert.assertTrue(techproHomePage.homeHeader.isDisplayed());


        // Sayfadan cikis yap ve cikis yapildigini test et
        techproHomePage.homeLogoutButton.click();

        // Cikis olduguna dair assertion yap
        Assert.assertTrue(techproLoginPage.submitButton.isDisplayed());

    }
}