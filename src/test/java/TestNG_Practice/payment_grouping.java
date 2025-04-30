package TestNG_Practice;

import org.testng.annotations.Test;

public class payment_grouping {

    @Test (priority = 1, groups = {"sanity" ,"regression"})
    void paymentinruppes()
    {
        System.out.println("payment in rupees");
    }

    @Test (priority = 2, groups = {"sanity" , "regression"})
    void paymentindollar()
    {
        System.out.println("payment in dollar");
    }

}
