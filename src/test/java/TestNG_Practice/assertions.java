package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertions {

    @Test
    void testTitle()
    {
        String exp_title="Open cart";
        String act_title="Open cart1";

        /* if (exp_title.equals(act_title))
        {
            System.out.println("Title matched");
        }
        else
        {
            System.out.println("Title is not matched");
        }*/

        Assert.assertEquals(exp_title,act_title);

    }
}
