import Pageobjects.MainPage;
import Pageobjects.RegisterNew;
import Pageobjects.RegisterSuccess;
import dataprovide.RegisterDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register extends Base
{
    private MainPage mainPage;
    private RegisterNew registerNew;
    private RegisterSuccess registerSuccess;

    @BeforeTest
    public void initialize()
    {
        driver  = InitializeDriver();
        mainPage = new MainPage(driver);
        registerNew = new RegisterNew(driver);
        registerSuccess = new RegisterSuccess(driver);
    }

    @BeforeMethod
    public void preCondition()
    {
        //go to the main page
        driver.get(mainPage.getUrl());
        //go to register form
        mainPage.goToRegister();
    }

    @Test (dataProvider = "valid data", dataProviderClass = RegisterDataProvider.class)
    public void testRegisterValidDate(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        registerNew.fill( FirstName,  LastName, Email, Telephone, password, confirm);
        Assert.assertTrue(registerSuccess.MessageisDisplayed());
    }

    @Test (dataProvider = "missing fields", dataProviderClass = RegisterDataProvider.class)
    public void testMissingFields(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        registerNew.fill( FirstName,  LastName, Email, Telephone, password, confirm);
        Assert.assertTrue(registerNew.generalErrorsDisplayed());
    }

    @Test (dataProvider = "duplicate email", dataProviderClass = RegisterDataProvider.class)
    public void EmailDuplicate(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        registerNew.fill( FirstName,  LastName, Email, Telephone, password, confirm);
        Assert.assertTrue(registerNew.DuplicateEmailDisplayed());
    }

    @Test (dataProvider = "invalidate email with com", dataProviderClass = RegisterDataProvider.class)
    public void InvalidateEmailCom(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        registerNew.fill( FirstName,  LastName, Email, Telephone, password, confirm);
        Assert.assertTrue(registerNew.InvalidEmailWithoutCom());
    }

    @Test (dataProvider = "invalidate email with arrob", dataProviderClass = RegisterDataProvider.class)
    public void InvalidateEmailArrob(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        registerNew.fill( FirstName,  LastName, Email, Telephone, password, confirm);
        Assert.assertFalse(registerNew.InvalidEmailWithoutArro());
    }

    @Test (dataProvider = "password not equal confirm", dataProviderClass = RegisterDataProvider.class)
    public void PasswordnotMatch(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        registerNew.fill( FirstName,  LastName, Email, Telephone, password, confirm);
        Assert.assertTrue(registerNew.PasswordNotMatch());
    }



    @AfterTest
    public void closeDriver()
    {
        driver.quit();
    }
}
