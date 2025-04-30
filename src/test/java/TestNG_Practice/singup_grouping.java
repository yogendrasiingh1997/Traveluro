package TestNG_Practice;

import org.testng.annotations.Test;

public class singup_grouping {

    @Test(priority = 1, groups = {"smoke"})
    void email()
    {
        System.out.println("singup by email");
    }

    @Test(priority = 2, groups = {"smoke"})
    void facebook()
    {
        System.out.println("singup by facebook");
    }

    @Test(priority = 3, groups = {"smoke"})
    void twitter()
    {
        System.out.println("singup by twitter");
    }

}
