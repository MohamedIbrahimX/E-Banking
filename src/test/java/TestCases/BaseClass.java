package TestCases;

import Utilites.ReadConfig;
import com.beust.jcommander.Parameter;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public String userName = readConfig.getUserName();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("Browser")
    @BeforeClass
    public void setUp(String browser){
        logger = Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");

        if(browser.equals("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    //To Make Screenshot

    public void captuerScreenShot(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

            File source =  takesScreenshot.getScreenshotAs(OutputType.FILE);
            File target = new File("E:\\ITI\\Studying\\Self Study\\Core\\Web Automation\\Selenium\\FrameWork\\E-BankingFrameWork\\ScreeenShots\\"+tname+".png");
            FileUtils.copyFile(source,target);
            System.out.println("ScreenShot Taken");
    }

    //User defined method created to check alert is present or not
    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

    public String randomString(){
        String generatedString = RandomString.make(8);
        return generatedString;
    }
}
