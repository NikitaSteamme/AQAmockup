import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;



public class Checkout {

    private static final Logger logger = LogManager.getLogger(Checkout.class);

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before

    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private WebDriver driver;




    @Test
    public void login(){
        driver.get("https://wallet.advcash.com/login");
        System.out.println("here");
        logger.warn("logger warn++");

        WebElement loginField = driver.findElement(By.cssSelector("#j_username"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='j_password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#j_idt51 > div > div > input[type=submit]"));

        loginField.sendKeys("test@outlook.com");
        passwordField.sendKeys("Qwerty123");
        loginButton.click();


    }


    @After
    public void closeBrowser(){
        if (driver!=null){
            driver.quit();
        }
    }
}