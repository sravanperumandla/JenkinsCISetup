package com.jenkins.ci.learning;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

public class BaseDriver {

	public AppiumDriver<WebElement> driver;
    private static AppiumDriverLocalService service;

    @BeforeClass
    public void setUp() throws Exception {
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();

//        if (service == null || !service.isRunning()) {
//            throw new AppiumServerHasNotBeenStartedLocallyException(
//                    "An appium server node is not started!");
//        }
        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "../../../apps/ApiDemos/bin");
//        File app = new File(appDir.getCanonicalPath(), "ApiDemos-debug.apk");
        File app=new File("/home/sravanp/git/JenkinsCISetup/src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", ".ApiDemos");
//        driver = new AndroidDriver<>(service.getUrl(), capabilities);
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }


    public MobileElement scrollTo(String text){
        return (MobileElement) driver.findElement(MobileBy.
                AndroidUIAutomator("new UiScrollable(new UiSelector()"
                        + ".scrollable(true)).scrollIntoView(resourceId(\"android:id/list\")).scrollIntoView("
                        + "new UiSelector().text(\""+text+"\"))"));
    }

}
