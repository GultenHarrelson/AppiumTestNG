package tests.ArambamTest;


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

public class ArabamComTest {
    AndroidDriver<AndroidElement> driver;
    @BeforeTest

    public  void  myCarTestSetup() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
       capabilities.setCapability("appPackage","com.dogan.arabam");
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public  void carTest(){
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
       AndroidElement kesfet=driver.findElementById("com.dogan.arabam:id/tvDiscover");
       kesfet.click();
       driver.findElementById("com.dogan.arabam:id/textViewSkip").click();




    }
}
