package TestNG_Practice;

import org.testng.annotations.*;

public class Annotation_2 {


    @BeforeMethod
    void BeforeMethod()
    {
        System.out.println("Before method");
    }

    @AfterMethod
    void AfterMethod()
    {
        System.out.println("after method");
    }

    @BeforeSuite
    void before_suit()
    {
        System.out.println("before suit");
    }

    @AfterSuite
    void after_suit()
    {
        System.out.println("after suit");
    }

    @BeforeTest
    void BeforeTest()
    {
        System.out.println("before test");
    }

    @AfterTest
    void AfterTest()
    {
        System.out.println("after test");
    }


    @Test(priority = 1)
    void search()
    {
        System.out.println("search");
    }

    @Test (priority = 2)
    void advance_search()
    {
        System.out.println("adv search");
    }


}
