import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AnishaFBtest {
    private WebDriver driver;
    private WebDriver d1river;
    private WebDriver d2river;
    private String baseUrl;

    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testFacebookLogin() throws Exception {
        driver.get("https://www.facebook.com/");
        WebElement email = driver.findElement(By.id("email"));
        email.click();
        email.clear();
        email.sendKeys("in28minutes");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("dummy");
        driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
