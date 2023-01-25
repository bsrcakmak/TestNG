package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.Practice_Driver;

public class Practice_YeniDriver {

    @Test
    public void testName() {
        Driver.getDriver().get("https://amazon.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://techproeducation.com");
        Driver.getDriver().get("https://facebook.com");


    }
}
