package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dependecy_Methods {

    @Test (priority = 1)
    void login()
    {
        Assert.assertTrue(true);
    }


    @Test(priority = 2, dependsOnMethods ={"login"} )
    void search()
    {
        Assert.assertTrue(false);
    }

    @Test (priority = 3, dependsOnMethods = {"search", "login"})
    void advance_search()
    {
        Assert.assertTrue(true);
    }

    @Test (priority = 4, dependsOnMethods = {"search"})
    void logout()
    {
        Assert.assertTrue(true);
    }

}
