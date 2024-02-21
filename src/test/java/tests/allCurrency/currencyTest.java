package tests.allCurrency;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrency;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class currencyTest {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
 AllCurrency allCurrency=new AllCurrency();


    // verifies that the all currency application is installed
    // confirms that the application is open
    // the currency we want to convert is selected as usd
    // select the currency to be converted to TL
    // the converted amount is saved as a screenShot
    // Then the tl value of usa against tl is recorded
    // this process is repeated in dollar- tl, sweden kroner- tl, Japanese yen- tl and notified to the user via sms

    @Test
    public  void  allCurrency() throws InterruptedException, IOException {
        System.out.println(driver.getDeviceTime());
        driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter");

     Assert.assertTrue(allCurrency.currency.isDisplayed());
        ReusableMethods.tiklamaMethodu(499,345,1000);
     ReusableMethods.scrollWithUiScrollable("USD");
     ReusableMethods.tiklamaMethodu(499,492,1000);
        ReusableMethods.scrollWithUiScrollable("TRY");
       //allCurrency.threeTimesClick(3,0);
       allCurrency.one.click();
       allCurrency.zero.click();
       allCurrency.zero.click();
       allCurrency.zero.click();
       // File fileSS= driver.getScreenshotAs(OutputType.FILE); // Taking ScreenSHot
      //  FileUtils.copyFile(fileSS,new File("usdToTl.jpg")); this first way to ScreenShot
        ReusableMethods.getScreenshot("usdToTl"); // this is the second way to take a ScreenShot
       String finalResult=allCurrency.result.getText();
       String phoneNumber="3312555578";
       driver.sendSMS(phoneNumber,finalResult);




          }
}
