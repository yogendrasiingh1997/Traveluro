package TestNG_Practice;

import org.testng.annotations.Test;

public class logingrouping {

    @Test(priority = 1, groups = {"sanity"})
    void email()
    {
        System.out.println("Login by email");
    }

    @Test(priority = 2, groups = {"sanity"})
    void facebook()
    {
        System.out.println("Login by facebook");
    }

    @Test(priority = 3, groups = {"sanity"})
    void twitter()
    {
        System.out.println("Login by twitter");
    }


}
