import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByIosNSPredicate;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class iOSPredicateString {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        MobileElement myElement = (MobileElement) ((FindsByIosNSPredicate) driver)
                .findElementByIosNsPredicate("label CONTAINS \"Activity Indicators\"");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]");
        System.out.println(myElement.getText());


    }
}
