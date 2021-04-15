package dataprovide;

import Utilities.StringFunctions;
import org.testng.annotations.DataProvider;

public class RegisterDataProvider
{
    int n = 15;

    @DataProvider(name = "valid data")
    public Object[][] validData() {
        return new Object[][]{
                {"Jose", "Pena", StringFunctions.randomEmail(n), "123456", "password123", "password123"}
        };
    }

    @DataProvider(name = "missing fields")
    public Object[][] missingField() {
        return new Object[][]{
                {null, "Pena", StringFunctions.randomEmail(n), "123456", "password123", "password123"},
                {"Jose", null, StringFunctions.randomEmail(n), "123456", "password123", "password123"},
                {"Jose", "Pena", null, "123456", "password123", "password123"},
                {"Jose", "Pena", StringFunctions.randomEmail(n), null, "password123", "password123"},
                {"Jose", "Pena", StringFunctions.randomEmail(n), "123456", null, "password123"},
                {"Jose", "Pena", StringFunctions.randomEmail(n), "123456", "password123", null}
        };
    }

    @DataProvider(name = "duplicate email")
    public Object[][] EmailDuplicate() {
        return new Object[][]{
                {"Jose", "Pena", "jose.pena@oktana.com", "123456", "password123", "password123"}
        };
    }

    @DataProvider(name = "invalidate email with com")
    public Object[][] InvalidateEmailCom() {
        return new Object[][]{
                {"Jose", "Pena", StringFunctions.randomEmailwithoutCom(n), "123456", "password123", "password123"}
        };
    }

    @DataProvider(name = "invalidate email with arrob")
    public Object[][] InvalidateEmailArrob() {
        return new Object[][]{
                {"Jose", "Pena", StringFunctions.randomEmailwithoutArro(n), "123456", "password123", "password123"}
        };
    }

    @DataProvider(name = "password not equal confirm")
    public Object[][] PasswordnotMatch() {
        return new Object[][]{
                {"Jose", "Pena", StringFunctions.randomEmail(n), "123456", "password123", "password"}
        };
    }

}
