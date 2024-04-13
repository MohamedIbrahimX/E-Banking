package TestCases;

import PageObject.LoginPage;
import Utilites.XLUtility;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{
    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(user);
        logger.info("userName provided");
        loginPage.setPassword(pwd);
        logger.info("Password provided");
        loginPage.clickSubmit();

        Thread.sleep(3000);

        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warning("Login failed");
        }else {
            Assert.assertTrue(true);
            logger.info("Login passed");
            loginPage.clicklogOut();
            Thread.sleep(3000);
            driver.switchTo().alert().accept(); //Close logout alert
            driver.switchTo().defaultContent();
        }
    }

    @DataProvider(name = "LoginData")
    String [] [] getData() throws IOException {
        String path = "E:\\ITI\\Studying\\Self Study\\Core\\Web Automation\\Selenium\\FrameWork\\E-BankingFrameWork\\src\\test\\java\\TestData\\LoginData.xlsx";
        XLUtility xlUtility = new XLUtility(path);
        int totalRows = xlUtility.getRowCount("Sheet1");
        int totalColumns = xlUtility.getCellCount("Sheet1", 1);
        String loginData[][] = new String[totalRows][totalColumns];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                loginData[i - 1][j] = xlUtility.getCellData("Sheet1", i, j);
            }
        }
        return loginData;

    }
}
