package tests.KiwiTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.kiwiPage;
import utilities.Driver;

public class KiwiCom {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    kiwiPage kiwiPage = new kiwiPage();
    TouchAction touchAction = new TouchAction(driver);

    @Test

    public void kiwiTest() throws InterruptedException {
        // confirms that the application is installed
        // confirms successful launch of the application
        // click to continue as a guest
        // continue with the next 3 steps by pressing the green button
        // Trip type is selected as one way
        // click on the departure country option and remove the default country
        // enter the country/city of departure and click select
        // click on the destination country option and enter the destination country
        // select the departure date as the 21st of May and click set date
        // click the search button
        // cheapest and transit-free filters are made
        // the incoming ticket price is saved and sent as an SMS to the user's phone

        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // AndroidElement guest=driver.findElementByXPath("//*[@text='Continue as a guest']");

        Assert.assertTrue(kiwiPage.guest.isDisplayed());
        kiwiPage.guest.click();

        kiwiPage.continueButton(0, 3, 492, 1692, 1000);
        // wait
        Thread.sleep(2000);
        // click one way
        kiwiPage.clickCoordinate(290, 627, 1000);
        Thread.sleep(1000);
        // click return
        kiwiPage.clickCoordinate(552, 1448, 1000);
        kiwiPage.clickCoordinate(502, 780, 1000);
        kiwiPage.clickCoordinate(1016, 135, 1000);
        Thread.sleep(2000);
        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Chicago");
        } else {
            kiwiPage.departureBox.sendKeys("Ankara");

        }
        Thread.sleep(1000);

        kiwiPage.clickCoordinate(493, 294, 1000);
        Thread.sleep(1000);

        kiwiPage.chooseButton.click();
        kiwiPage.clickCoordinate(431, 906, 1000);

        if (driver.isKeyboardShown()) {
            driver.getKeyboard().pressKey("Chicago");
        } else {
            kiwiPage.departureBox.sendKeys("Germany");

        }
        Thread.sleep(1000);

        kiwiPage.clickCoordinate(493, 294, 1000);
        kiwiPage.chooseButton.click();
        kiwiPage.clickCoordinate(474,1046,1000);
         kiwiPage.scrollDown(490,1349,850,508,202,1000);
        kiwiPage.clickCoordinate(262, 899, 1000);
        kiwiPage.saveButton.click();
        Thread.sleep(1000);
        kiwiPage.clickCoordinate(535, 1395, 1000);
        kiwiPage.clickCoordinate(272, 254, 1000);
        kiwiPage.clickCoordinate(538, 584, 1000);
        kiwiPage.clickCoordinate(529, 237, 1000);
        kiwiPage.clickCoordinate(521, 1448, 1000);
        Thread.sleep(1000);
        String  kiwiPrice=kiwiPage.price.getText();
        String phoneNumber="5555555555";
        driver.sendSMS(phoneNumber,kiwiPrice);





    }
}
