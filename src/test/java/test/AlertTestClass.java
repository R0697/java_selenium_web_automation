package test;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeForm;
import pages.WindowsAlertsFrames;

public class AlertTestClass extends BaseTest {

    public PracticeForm practiceForm = new PracticeForm();
    public WindowsAlertsFrames windowsAlertsFrames = new WindowsAlertsFrames();

    @Test(description = "Click Button to see alert")
    public void clickButtonToSeeAlert() {

        windowsAlertsFrames.navigateToAlertFramesAndWindows();
        windowsAlertsFrames.navigateTo(windowsAlertsFrames.alertSideBarLocator);
        practiceForm.waitForElementAppear(windowsAlertsFrames.alertButtonLocator, 5);
        practiceForm.clickOnElement(windowsAlertsFrames.alertButtonLocator);
        String text = windowsAlertsFrames.acceptAlert();
        Assert.assertEquals(text, "Hello world!", "Actual text of alerts is not matched " +
                "with the expected text");

    }

    @Test(description = "On button click, alert will appear after 5 seconds")
    public void verifyAlertWillDisplayAfterFiveSeconds() {

        windowsAlertsFrames.clickOnClickMeButton(1);
        sleep(5000);
        String text = windowsAlertsFrames.acceptAlert();
        Assert.assertEquals(text, "Hello just appeared", "Actual text of alerts is not matched " +
                "with the expected text");
    }

    @Test(description = "On button click, confirm box will appear")
    public void verifyConfirmBoxWillAppear() {

        windowsAlertsFrames.clickOnClickMeButton(2);
        sleep(1000);
        String accept_text = windowsAlertsFrames.acceptAlert();
        Assert.assertEquals(accept_text, "Press a button!", "Actual text of alerts is not matched " +
                "with the expected text after accepting the alert");
        practiceForm.waitForElementAppear(windowsAlertsFrames.youPressedOkMessageLocator, 5);
        windowsAlertsFrames.clickOnClickMeButton(2);
        String dismiss_text = windowsAlertsFrames.dismissAlert();
        Assert.assertEquals(dismiss_text, "Press a button!", "Actual text of alerts is not matched " +
                "with the expected text after dismissing the alert");
        practiceForm.waitForElementAppear(windowsAlertsFrames.youPressedCancelMessageLocator, 5);
    }

    @Test(description = "On button click, prompt box will appear")
    public void verifyPromptWillAppear() {

        windowsAlertsFrames.clickOnClickMeButton(3);
        windowsAlertsFrames.enterTextInAlertAndAccept("Accept");
        windowsAlertsFrames.clickOnClickMeButton(3);
        windowsAlertsFrames.enterTextInAlertAndDismiss("Dismiss");
    }
}
