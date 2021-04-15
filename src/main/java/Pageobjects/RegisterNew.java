package Pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterNew
{
    private final WebDriver driver;

    @FindBy(id = "input-firstname")
    WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    WebElement inputLastName;

    @FindBy(id = "input-email")
    WebElement inputEmail;

    @FindBy(id = "input-telephone")
    WebElement inputTelephone;

    @FindBy(id = "input-password")
    WebElement inputpassword;

    @FindBy(id = "input-confirm")
    WebElement inputconfirm;

    @FindBy(name = "newsletter")
    List<WebElement> button;

    @FindBy(name = "agree")
    WebElement ckeckpolicy;

    @FindBy(xpath = "//input[(@value = 'Continue')]")
    WebElement btncontinue;

    @FindBy(className = "text-danger")
    WebElement generalError;

    @FindBy(xpath = "//div[contains(.,'Warning: E-Mail Address is already registered!')]")
    WebElement duplicateEmailError;

    @FindBy(xpath = "//div[contains(.,'E-Mail Address does not appear to be valid!')]")
    WebElement InvalidEmailMessagewithCom;

    @FindBy(xpath = "//div[contains(.,'Password confirmation')]")
    WebElement PasswordNotMatchMessage;


    public RegisterNew(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void fill(String FirstName, String LastName,String Email,String Telephone,String password,String confirm)
    {
        if(FirstName != null){
            inputFirstName.sendKeys(FirstName);
        }

        //Enter last name
        if(LastName != null){
            inputLastName.sendKeys(LastName);
        }

        //Enter email
        if(Email != null){
            inputEmail.sendKeys(Email);
        }

        //Enter telephone
        if(Telephone != null){
            inputTelephone.sendKeys(Telephone);
        }

        //Enter password
        if(password != null){
            inputpassword.sendKeys(password);
        }

        //Enter confirm password
        if(confirm != null){
            inputconfirm.sendKeys(confirm);
        }


        button.get(0).click();
        ckeckpolicy.click();
        btncontinue.click();
    }

    public boolean generalErrorsDisplayed() {
        return generalError.isDisplayed();
    }

    public boolean DuplicateEmailDisplayed() {
        return duplicateEmailError.isDisplayed();
    }

    public boolean InvalidEmailWithoutCom() {
        return InvalidEmailMessagewithCom.isDisplayed();
    }

    public boolean InvalidEmailWithoutArro() {
        WebElement inputElement = driver.findElement(By.name("email"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",inputElement);
        return isRequired;

    }

    public boolean PasswordNotMatch() {
        return PasswordNotMatchMessage.isDisplayed();
    }




}
