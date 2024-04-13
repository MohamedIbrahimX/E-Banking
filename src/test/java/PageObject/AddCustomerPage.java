package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
    WebDriver ldriver;
    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
    @CacheLookup
    WebElement lnkAddNewCustomer;
    @FindBy(name = "name")
    @CacheLookup
    WebElement txtCustomerName;
    @FindBy(name = "rad1")
    @CacheLookup
    WebElement rdGender;
    @FindBy(name = "dob")
    @CacheLookup
    WebElement txtdob;
    @FindBy(name = "addr")
    @CacheLookup
    WebElement txtAddress;
    @FindBy(name = "city")
    @CacheLookup
    WebElement txtCity;
    @FindBy(name = "state")
    @CacheLookup
    WebElement txtState;
    @FindBy(name = "pinno")
    @CacheLookup
    WebElement txtPinno;
    @FindBy(name = "telephoneno")
    @CacheLookup
    WebElement txtTelephoneno;
    @FindBy(name = "emailid")
    @CacheLookup
    WebElement txtEmailid;
    @FindBy(name = "sub")
    @CacheLookup
    WebElement btnSubmit;

    public void clickAddNewCustomer(){
        lnkAddNewCustomer.click();
    }
    public void custName(String cname){
        txtCustomerName.sendKeys(cname);
    }
    public void custGender(String cgender){
        rdGender.click();
    }
    public void custDob(String mm, String dd, String yy){
        txtdob.sendKeys(mm);
        txtdob.sendKeys(dd);
        txtdob.sendKeys(yy);
    }
    public void custAddress(String caddress){
        txtAddress.sendKeys(caddress);
    }
    public void custCity(String ccity){
        txtCity.sendKeys(ccity);
    }
    public void custState(String cstate){
        txtState.sendKeys(cstate);
    }
    public void custPinno(String cpinno){
        txtPinno.sendKeys(cpinno);
    }
    public void custTelephoneno(String ctelephoneno){
        txtTelephoneno.sendKeys(ctelephoneno);
    }
    public void custEmailid(String cemailid){
        txtEmailid.sendKeys(cemailid);
    }
    public void custSubmit(){
        btnSubmit.click();
    }
}
