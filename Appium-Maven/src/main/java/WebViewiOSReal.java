import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewiOSReal {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(MobileBy.AccessibilityId("Or connect using a social account.")).click();
        driver.findElement(MobileBy.AccessibilityId("Google")).click();
//        Thread.sleep(5000);

        Set<String> contextHandles = driver.getContextHandles();
        for(Object contextHandle: contextHandles){
            System.out.println(contextHandle.toString());
        }
        driver.context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("#headingText > span")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"headingText\"]/span")).getText());

        driver.context("NATIVE_APP");
        driver.quit();
    }
}
