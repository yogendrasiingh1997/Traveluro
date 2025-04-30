package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_assertions {

    @Test
    void test()
    {
        Assert.assertEquals("xyz", "xyz");

        Assert.assertNotEquals(123,123);

        Assert.assertTrue(true);

        Assert.assertFalse(false);

        Assert.fail();
    }


}
