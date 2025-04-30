package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoft_asserations {

    @Test
    void softassertions()
    {
        System.out.println("Yes");
        System.out.println("No");

        SoftAssert sa= new SoftAssert();

        //Assert.assertEquals(1,2); // hard assertion

        sa.assertEquals(1,2);

        System.out.println("ball");
        System.out.println("bat");

        sa.assertAll(); //mandatory method
    }
}
