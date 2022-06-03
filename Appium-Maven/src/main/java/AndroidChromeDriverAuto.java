import io.appium.java_client.AppiumDriver;

import java.util.concurrent.TimeUnit;

public class AndroidChromeDriverAuto {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://tesla.com");
    }
}
