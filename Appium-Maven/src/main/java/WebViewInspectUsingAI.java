import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebViewInspectUsingAI {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

  //      driver.findElement(MobileBy.AccessibilityId("Views")).click();

        Dimension size = driver.manage().window().getSize();

        for(int i=0;i<1;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }

        driver.findElement(MobileBy.AccessibilityId("Web View")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(MobileBy.AccessibilityId("This is HTML content inside a WKWebView ."))
                .getAttribute("label"));

    }
}
