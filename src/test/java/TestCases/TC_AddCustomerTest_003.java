package TestCases;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import com.beust.ah.A;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static TestCases.BaseClass.driver;

public class TC_AddCustomerTest_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.clickAddNewCustomer();
        logger.info("Providing customer details...");
        addCustomerPage.custName("Mohamed");
        addCustomerPage.custGender("male");
        addCustomerPage.custDob("06","18","2001");
        Thread.sleep(3000);
        addCustomerPage.custAddress("Egypt");
        addCustomerPage.custCity("Giza");
        addCustomerPage.custState("MI");
        addCustomerPage.custPinno("2572001");
        addCustomerPage.custTelephoneno("01202213167");
        String email = randomString() + "@gmail.com";
        addCustomerPage.custEmailid(email);
        addCustomerPage.custSubmit();
        Thread.sleep(3000);

        logger.info("Validation started....");

        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(true);
            logger.info("New Customer Added");
        }else {
            logger.warning("Not Added New Customer");
            captuerScreenShot(driver,"AddNewCustomer");
            Assert.assertTrue(false);
        }
    }

}
