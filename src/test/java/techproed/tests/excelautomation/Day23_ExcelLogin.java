package techproed.tests.excelautomation;

import org.openqa.selenium.devtools.v106.input.model.DragDataItem;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {


    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String,String >> excelDatalari;

    // Bu method Login sayfasina gitmek icin kullanilacak
    @Test
    public void login() {

        // Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        // Home Page Login e tikla
        blueRentalHomePage= new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        // ---------- SADECE ILK GIRIS ---------
        // loginlink butonu sadece ilk giristeki sayfada gorunur
        // 2. ve 3. girislerde sayfada gorunmeyeceginden NoSuchElementException alinir
        // Biz bu exception'i try-catch kullanarak yakalariz ve test cases calismaya devam eder

        try{
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
            // LOGIN sayfasindayiz
        }catch (Exception e){

        }

        // --------SONRAKI GIRISLER --------

        try {
            // kullanici ID ye tikla  --> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            // Logout linkine tikla   --> try catch
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
            // OK e tikla             --> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            // homepage logine tikla  --> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
            // LOGIN sayfasindayiz
        }catch (Exception e){

        }
    }


    @Test
    public void customerLogin(){

        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        // ./ bu ifade onceki tum dosyalari icer anlamindadir (relative path)

        String sheetName = "customer_info";

        // Datalari EXCEL UTILS METHODLARI kullanarak buraya alacagiz.
        excelUtils = new ExcelUtils(path,sheetName);

        // Excel datalarini getDataList() methodu ile cekelim
        excelDatalari = excelUtils.getDataList();

        // Loop kullanarak datalari tek tek test case de kullan
        for (Map<String,String> data:excelDatalari) {
            login(); // Her loopda Login sayfasina goturecek

            // kullanici adini gir
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);

            // kullanici sifresini gir
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            ReusableMethods.waitFor(1);

            // Login butonuna tikla
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);

        }
    }
}

    /*
    sam.walker@bluerentalcars.com	c!fas_art
    kate.brown@bluerentalcars.com	tad1$Fas
    raj.khan@bluerentalcars.com	    v7Hg_va^
    pam.raymond@bluerentalcars.com	Nga^g6!

    ------ ILK GIRIS -------

    *** HOME PAGE DEYIZ
    homepage logine tikla --> try catch
    *** LOGIN PAGE DEYIZ
    kullanici adini gir (excelden al)
    kullanici sofreyi gir (excelden al)
    login page login butonuna tikla

    ------- 2. GIRIS -------

    *** HOME PAGE DEYIZ
    kullanici ID ye tikla  --> try catch
    Logout linkine tikla   --> try catch
    OK e tikla             --> try catch
    homepage logine tikla  --> try catch
    *** LOGIN PAGE DEYIZ
    kullanici adini gir (excelden al)
    kullanici sofreyi gir (excelden al)
    login page login butonuna tikla

    --------- 3. GIRIS ---------

    *** HOME PAGE DEYIZ
    kullanici ID ye tikla
    Logout linkine tikla
    OK e tikla
    homepage logine tikla
    *** LOGIN PAGE DEYIZ
    kullanici adini gir (excelden al)
    kullanici sofreyi gir (excelden al)
    login page login butonuna tikla

    --------- 4. GIRIS ---------

    *** HOME PAGE DEYIZ
    kullanici ID ye tikla
    Logout linkine tikla
    OK e tikla
    homepage logine tikla
    *** LOGIN PAGE DEYIZ
    kullanici adini gir (excelden al)
    kullanici sofreyi gir (excelden al)
    login page login butonuna tikla

     */