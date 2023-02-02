package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

   @DataProvider
   public Object[][] musteriVerileri(){
          Object[][] musteriGirisBilgileri= {
                  {"maneger1", "12345","Besiktas"},
                  {"maneger2", "98765","Cebeci"},
                  {"maneger3", "5678","Karsiyaka"}
          } ;
          return musteriGirisBilgileri;
    }


    @DataProvider
    public Object[][] musteriHizmetleriVerileri(){
        Object[][] musteriHizmetleriGirisBilgileri= {
                {"adam1", "3456"},
                {"ali2", "1234"},
                {"nancy3", "7890"}
        } ;
        return musteriHizmetleriGirisBilgileri;
    }

    @DataProvider
    public Object[][] personelVerileri(){
        Object[][] personelGirisBilgileri= {
                {"rukiye1", "abc1"},
                {"mehmet2", "123r"},
                {"emin3", "3edc"},
                {"baran4", "4asd"},
                {"okumus5", "6e45"},
        } ;
        return personelGirisBilgileri;
    }


    // Excel den Data Provider'a data gelir
    // Burdan da Test Case'e gider
    @DataProvider
    public Object[][] customerData(){

        // DataProviderTest2 ile bu method arasindaki tek fark bu methodda datalar excel'den gelir
        // Bu kullanim daha guzeldir.

        String path= "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        Object[][] musteriBilgileri = excelUtils.getDataArrayWithoutFirstRow();
        // excelde ilk satir haricindeki butun datalari 2D Array olarak verir

        return musteriBilgileri;
    }




}
