import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewiOSSimAutomate {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
 //       Thread.sleep(10000);

        Set<String> contextHandles = driver.getContextHandles();
        for(String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }

        driver.context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.context("NATIVE_APP");
        driver.findElement(MobileBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
        driver.quit();

    }
}
