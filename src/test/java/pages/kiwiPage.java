package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class kiwiPage {
    public kiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);

    }
    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement  guest;
    @FindBy(xpath ="//*[@class='android.widget.EditText']")
    public  WebElement departureBox;
    @FindBy(xpath = "//*[@text='Choose']")
    public  WebElement chooseButton;
    @FindBy(id = "com.skypicker.main:id/saveButton")
    public WebElement saveButton;
    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement price;

    public  void  continueButton(int iStart,int iEnd,int xCoordinate,int yCoordinate,int wait) throws InterruptedException {
        TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());
        for(int i=iStart;i<iEnd;i++){
            touchAction.press(PointOption.point(xCoordinate,yCoordinate)).release().perform();
            Thread.sleep(wait);

        }


    }
    public  void clickCoordinate(int xCoordinate,int yCoordinate,int wait ) throws InterruptedException {
        TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());
        touchAction.press(PointOption.point(xCoordinate,yCoordinate)).release().perform();
        Thread.sleep(wait);



    }
    public  void  scrollDown(int xCoordinate,int yCoordinate,int waitint ,int xMCoordinate,int yMCoordinate,int wait) throws InterruptedException {
        TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());
        touchAction.press(PointOption.point(xCoordinate,yCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(xMCoordinate,yMCoordinate))
                .release().perform();
        Thread.sleep(wait);
    }

}
