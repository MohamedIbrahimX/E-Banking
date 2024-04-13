package TestCases;

import PageObject.LoginPage;
import TestCases.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {

        logger.info("URL is Opened");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        logger.info("Entered userName");
        loginPage.setPassword(password);
        logger.info("Entered password");
        loginPage.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login test passed");
        }else {
            captuerScreenShot(driver,"LoginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }

}
