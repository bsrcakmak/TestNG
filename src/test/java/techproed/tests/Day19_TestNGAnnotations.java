package techproed.tests;

import org.testng.annotations.*;

public class Day19_TestNGAnnotations {

    /*
    @Test : Test case olusturmak icin kullanilan bir annotation'dir
    @Before ve @After : 5 Before ve 5 After annotations var
    suite > tests > grups > class > method
    @BeforeSuite : her bir test suite den once 1 sefer calisir
    @AfterSuite : her bir test suiteden sonra 1 sefer calisir
    @BeforeTest : her bir testden once(TEST CASE ILE KARISTIRILMAMALI) 1 sefer calisir
    @AfterTest : her bir testden sonra(TEST CASE ILE KARISTIRILMAMALI) 1 sefer calisir
    @BeforeClass: her bir classdan once 1 sefer calisir
    @AfterClass: her bir classdan sonra 1 sefer calisir
    @BeforeMethod: her bir @Test annotationdan once tek sefer calisir. JUnitdeki karsiligi @Before
    @AfterMethod: her bir @Test annotationdan sonra tek sefer calisir. JUnitdeki karsiligi @After
    -------------------------------------------------------------------------------------------
    @Ignore : @Test case'leri atlamak(skip,ignore) icin kullanilir
    @Test(enabled = false) : test caseleri devre disi birakmak icin kullanilir cok gucludur run oku bile kalkar
    -------------------------------------------------------------------------------------------
    TestNG de test case'ler isim sirasina gore calisir
    @Test(priority=1) :Test case'leri oncelemek icin kullanilir
    NOT: default priority'nin degeri 0'a esittir.

     */


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before Groups");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }



    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }



    @Test(priority = 1, groups = "regression-tests")
    public void test7() {
        System.out.println("Test 7");
    }
    @Test @Ignore
    public void test2() {
        System.out.println("Test 2");
    }
    @Test(enabled = false, groups = "regression-tests")      // testi kullanmamak icin eklenir enable=false,
                                // cok guclu yanindaki run oku bile kalkar
    public void test3() {
        System.out.println("Test 3");
    }
    @Test(priority = 4)
    public void test4() {
        System.out.println("Test 4");
    }
    @Test(priority = 2)
    public void test5() {
        System.out.println("Test 5");
    }
    @Test(priority = -5)
    public void test6() {
        System.out.println("Test 6");
    }
}
