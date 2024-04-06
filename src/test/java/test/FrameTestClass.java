package test;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeForm;
import pages.WindowsAlertsFrames;

public class FrameTestClass extends BaseTest {

    public PracticeForm practiceForm = new PracticeForm();
    public WindowsAlertsFrames windowsAlertsFrames = new WindowsAlertsFrames();

    @Test(description = "Frame 1 text verification")
    public void clickButtonToSeeAlert() {

        windowsAlertsFrames.navigateToAlertFramesAndWindows();
        windowsAlertsFrames.navigateTo(windowsAlertsFrames.frameSideBarLocator);
        practiceForm.waitForElementAppear(windowsAlertsFrames.frameLabelLocator, 5);
        String textFromIFrame = windowsAlertsFrames.iFrame(windowsAlertsFrames.firstFrameLocator,
                windowsAlertsFrames.newTabUnderIFrame);
        System.out.println("Value of text: " + textFromIFrame);
        Assert.assertEquals(textFromIFrame, "New Tab", "Expected value is not present in the First iFrame");
    }
}
