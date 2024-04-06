package test;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PracticeForm;
import pages.WindowsAlertsFrames;
import utilities.Listners;

@Listeners(Listners.class)
public class WindowTestClass extends BaseTest {

    public PracticeForm practiceForm = new PracticeForm();
    public WindowsAlertsFrames windowsAlertsFrames = new WindowsAlertsFrames();

    @Test(description = "Verify the new tab open successfully by clicking on it")
    public void clickOnNewTabButtonAndVerifyNewTab() {

        String mainWindowId = driver.getWindowHandle();
        windowsAlertsFrames.navigateTo(windowsAlertsFrames.alertFrameWindows);
        windowsAlertsFrames.navigateTo(windowsAlertsFrames.browserWindow);
        windowsAlertsFrames.verifyButtonAreDisplayed(windowsAlertsFrames.newTabButton);
        sleep(2000);
        windowsAlertsFrames.switchToNewWindow();
        practiceForm.waitForElementAppear(windowsAlertsFrames.newTabLabel, 10);
        windowsAlertsFrames.closeBrowserWindow();
        windowsAlertsFrames.switchToMainWindow(mainWindowId);
        practiceForm.waitForElementAppear(windowsAlertsFrames.newTabButton, 10);
    }

    @Test(description = "Verify the new window open successfully by clicking on it")
    public void verifyNewWindowByClickingOnIt() {

        String mainWindowId = driver.getWindowHandle();
        windowsAlertsFrames.verifyButtonAreDisplayed(windowsAlertsFrames.newWindowButton);
        sleep(2000);
        windowsAlertsFrames.switchToNewWindow();
        practiceForm.waitForElementAppear(windowsAlertsFrames.newWindowLabel, 5);
        String text = practiceForm.getTextFromElement("xpath", windowsAlertsFrames.newWindowLabel);
        System.out.println("Value of text: " + text);
        Assert.assertEquals(text, "New Window", "Actual text "+ text +" is not matched");
        windowsAlertsFrames.closeBrowserWindow();
        windowsAlertsFrames.switchToMainWindow(mainWindowId);
        practiceForm.waitForElementAppear(windowsAlertsFrames.newTabButton, 5);
    }

    @Test(description = "Verify the new window message button by clicking on it")
    public void verifyNewWindowMessageByClickingOnIt() {

        String mainWindowId = driver.getWindowHandle();
        windowsAlertsFrames.verifyButtonAreDisplayed(windowsAlertsFrames.newWindowMessageButton);
        sleep(2000);
        windowsAlertsFrames.switchToNewWindow();
        practiceForm.waitForElementAppear(windowsAlertsFrames.newWindowMessageLabel, 5);
        String text = practiceForm.getTextFromElement("xpath", windowsAlertsFrames.newWindowMessageLabel);
        System.out.println("Value of text: " + text);
        Assert.assertEquals(text, "New Window Message", "Actual text "+ text +" is not matched");
        windowsAlertsFrames.closeBrowserWindow();
        windowsAlertsFrames.switchToMainWindow(mainWindowId);
        practiceForm.waitForElementAppear(windowsAlertsFrames.newTabButton, 5);
    }
}
