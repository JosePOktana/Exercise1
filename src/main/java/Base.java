import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base
{
    public WebDriver driver;

    public WebDriver InitializeDriver()
    {
        //String webDriverPath = System.getProperty("user.dir") + "/tools/chromedriver";
        //System.setProperty("webdriver.chrome.driver", webDriverPath);
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }
}
