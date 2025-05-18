package abound.core;

import org.testng.Assert;

public class AssertionUtil
{
    public static void assertNotNull(Object field , String fieldName)
    {
        Assert.assertNotNull(field,fieldName + " should not be null");
    }

}
