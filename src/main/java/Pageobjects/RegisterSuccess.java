package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccess
{
    private final WebDriver driver;

    @FindBy(xpath = "//h1[contains(. , 'Created')]")
    WebElement MessageSuccess;

    public RegisterSuccess(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean MessageisDisplayed()
    {
        return  MessageSuccess.isDisplayed();
    }
}
