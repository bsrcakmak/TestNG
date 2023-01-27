package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    // Page Object'lerini bu sinifta buluruz

    // 1. constructor olustururuz, her page bir const. ile baslamak zorundadir.

    public OpenSourcePage(){
        // PageFactory Selenium'dan gelen ve bu sayfa elementlerini instantiate etmek icin kullanilir
        // Bu sekilde sayfa objeleri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(),this);
        // this =>  Driver clasindaki driver budur demektir.
    }

    // Page Object'lerini olustururuz
    // GELENEKSEL YOL ==> public WebElement username=Driver.getDriver().findElement(By.name("username"));

    @FindBy(name = "username")  // POM da locate alirken @FindBy kullaniriz
    public WebElement username;

    @FindBy(xpath= "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    // Bu sayfanin amaci OpenSourcePage deki elementleri bulmak,
    // OpenSourcePage sayfasina her gidiste bu locate leri kolayca cagirabilecegiz.






}
