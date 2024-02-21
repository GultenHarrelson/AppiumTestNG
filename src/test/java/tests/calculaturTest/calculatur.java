package tests.calculaturTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class calculatur {
    AndroidDriver<AndroidElement> driver;
   // AppiumDriver<AndroidElement> driver2;
    @Test

    public  void test01() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
       // capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\gulte\\IdeaProjects\\AppiumPractice\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");
        driver=new  AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.activateApp("com.google.android.calculator");
         driver.isAppInstalled("com.google.android.calculator");
         Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
         AndroidElement acButtonu=driver.findElementByAccessibilityId("clear");
         // verify if the ACbutton is  displayed
         Assert.assertTrue(acButtonu.isDisplayed());

         driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("3").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("equals").click();

         String result=driver.findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println(result); // here show the result 2700
        Assert.assertEquals(Integer.parseInt(result),2700); // here needed to cast to  parseInt because the result is String
       // driver.sendSMS("55555555","Hi Michael how are you");





    }
}
