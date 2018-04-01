package com.jenkins.ci.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidTest extends BaseDriver {
	
	@Test
    public void apiDemo(){
        WebElement el = driver.findElement(By.xpath(".//*[@text='Animation']"));
        Assert.assertEquals("Animation", el.getText());
        el = driver.findElementByClassName("android.widget.TextView");
        Assert.assertEquals("API Demos", el.getText());
        el = driver.findElement(By.xpath(".//*[@text='App']"));
        el.click();
        List<WebElement> els = driver.findElementsByClassName("android.widget.TextView");
        Assert.assertEquals("Activity", els.get(2).getText());
    }

}
