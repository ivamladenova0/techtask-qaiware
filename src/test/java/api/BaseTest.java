package api;

import org.testng.Assert;

public class BaseTest {

    public void verify(Object actual, Object expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public void verifyIntValues(int actual, String expected, String message){

        int expectedInInt = Integer.parseInt(expected);
        Assert.assertEquals(actual, expectedInInt, message);
    }
}