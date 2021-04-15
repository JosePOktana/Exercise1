package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.applet.Main;

public class MainPage
{
    private final WebDriver driver;

    private final String url = "https://demo.opencart.com/";

    @FindBy(xpath = "//span[contains(. , 'My Account')]")
    WebElement myAccount;

    @FindBy(xpath = "//a[contains(. , 'Register')]")
    WebElement register;

    @FindBy(xpath = "//ul[contains(@class, 'menu-right')]//a[contains(. , 'Logout')]")
    WebElement logout;

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToRegister()
    {
        myAccount.click();
        register.click();
    }

    public String getUrl()
    {
        return url;
    }

    public void Out()
    {
        myAccount.click();
        logout.click();
    }


}
