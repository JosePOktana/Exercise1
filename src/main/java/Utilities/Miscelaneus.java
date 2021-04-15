package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Miscelaneus
{
    public static void highLighterMethod (WebDriver driver, WebElement element) throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor)  driver;
        js.executeScript(
                "arguments[0].setAttribute('style', 'background: green; border:3px solid blie;');",element);
        Thread.sleep(1000);
        js.executeScript("arguments[0].removeAttribute('style','')", element);
    }
}
