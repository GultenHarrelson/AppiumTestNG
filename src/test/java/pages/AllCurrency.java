package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AllCurrency {
    public  AllCurrency(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='CURRENCY CONVERTER']")
    public  WebElement currency;
    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b1")
    public  WebElement one;
    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/b0")
    public  WebElement  zero;
    @FindBy(id="com.smartwho.SmartAllCurrencyConverter:id/EditTextCurrencyB")
    public  WebElement result;
}
