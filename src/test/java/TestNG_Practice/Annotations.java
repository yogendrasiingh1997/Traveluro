package TestNG_Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

    @BeforeMethod
    void login()
    {
        System.out.println("login");
    }


    @Test (priority = 1)
    void search()
    {
        System.out.println("search");
    }

    @Test (priority = 2)
    void advance_search()
    {
        System.out.println("adv searc");
    }

    @AfterMethod
    void logout()
    {
        System.out.println("logout");
    }

}
