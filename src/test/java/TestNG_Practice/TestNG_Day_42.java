package TestNG_Practice;


import org.testng.annotations.Test;

public class TestNG_Day_42 {

    @Test(priority=1)
       void openwebsite()
    {
        System.out.println("open website");
    }


    @Test(priority=2)
    void login()
    {
        System.out.println("login");
    }

    @Test(priority=3)
    void logout()
    {
        System.out.println("logout");
    }

}
