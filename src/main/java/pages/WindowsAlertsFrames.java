package pages;

import baseTest.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

public class WindowsAlertsFrames extends BaseTest {

    public PracticeForm practiceForm = new PracticeForm();

    public String alertFrameWindows = "//h2[@id='headingThree']";
    public String browserWindow = "//a[contains(text(), 'Browser Windows')]";
    public String newTabButton = "//button[contains(text(), 'New Tab')]";
    public String newWindowButton = "//button[text()='New Window']";
    public String newWindowMessageButton = "//button[contains(text(), 'New Window Message')]";
    public String newTabLabel = "//*[contains(text(), 'New Tab')]";
    public String newWindowLabel = "//*[contains(text(), 'New Window')]";
    public String newWindowMessageLabel = "//*[contains(text(), 'New Window Message')]";
    public String alertSideBarLocator = "//a[contains(text(), 'Alert')]";
    public String frameSideBarLocator = "(//a[contains(text(), 'Frames')])[1]";
    public String alertButtonLocator = "(//button[contains(text(), 'Alert')])[2]";
    public String frameLabelLocator = "//h1[text()='Frames']";
    public String clickMeBtnLocator = "(//button[contains(text(), 'Click Me')])";
    public String youPressedOkMessageLocator = "//*[contains(text(), 'You pressed OK!')]";
    public String youPressedCancelMessageLocator = "//*[contains(text(), 'You pressed Cancel!')]";
    public String firstFrameLocator = "//iframe[contains(@width, '100')]"; // id and name is not present of the frame
    public String secondFrameLocator = "//iframe[contains(@width, '30')]"; // id and name is not present of the frame
    public String newTabUnderIFrame = "/html/body[@class='text-center']//h1[.='New Tab']"; // id and name is not present of the frame

    // Navigate to Alert, Frames & Windows
    public void navigateToAlertFramesAndWindows() {
        driver.findElement(By.xpath(alertFrameWindows)).click();
    }
    public void navigateTo(String xpath) {
        practiceForm.isElementDisplayed(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    // Method to scroll window till element not visible
    public void scrollPageWhileElementNotAppear(String xpath)
    {
        WebElement element = driver.findElement(By.xpath(xpath));
        Actions act = new Actions(driver);
        act.scrollToElement(element);
        act.scrollByAmount(0, 500);
        sleep(2000);

    }

    // Method to switch to new window
    public void switchToNewWindow()
    {
        sleep(2000);
        String mainWindowId = driver.getWindowHandle();
        System.out.println("Main Window Id: " +mainWindowId);
        Set<String> allWindowId = driver.getWindowHandles();
        System.out.println("All Windows ID: " + allWindowId);
        for(String childWindow: allWindowId)
        {

            System.out.println("Child Window Id: " + childWindow);
            if(!(mainWindowId.equalsIgnoreCase(childWindow)))
            {
                driver.switchTo().window(childWindow);
                System.out.println("----- Switch to Child Window ------");
            }
        }
        sleep(2000);
    }

    // Method to switch back to main window
    public void switchToMainWindow(String windowId)
    {
        sleep(2000);
//        String mainWindowId = driver.getWindowHandle();
        System.out.println("switchToMainWindow: " + windowId);
        driver.switchTo().window(windowId);
        driver.navigate().refresh();
    }

    public void closeBrowserWindow() {
        sleep(2000);
        driver.close();
    }

    // Verification methods
    public void verifyButtonAreDisplayed(String xpath) {
        if(practiceForm.isElementDisplayed(xpath)) {
            practiceForm.clickOnElement(xpath);
            sleep(3000);
        }
    }

    public String acceptAlert() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.accept();
        return textOnAlert;
    }

    public String dismissAlert() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        alert.dismiss();
        return textOnAlert;
    }

    public void enterTextInAlertAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        char[] a = text.toCharArray();
        for (char c : a) {
            alert.sendKeys(String.valueOf(c));
            sleep(1000);
        }
        alert.accept();
    }

    public void enterTextInAlertAndDismiss(String text) {
        Alert alert = driver.switchTo().alert();
        char[] a = text.toCharArray();
        for (char c : a) {
            alert.sendKeys(String.valueOf(c));
            sleep(1000);
        }
        alert.dismiss();
    }

    public void clickOnClickMeButton(int index) {
        sleep(1000);
        driver.findElement(By.xpath(clickMeBtnLocator+"["+index+"]")).click();
    }

    public String iFrame(String frameXpath, String locatorXpath) {
        driver.switchTo().frame(frameXpath);
        WebElement element = driver.findElement(By.xpath(locatorXpath));
        String textFromIFrame = element.getText();
        System.out.println("Value of locator: " + textFromIFrame);
        driver.switchTo().defaultContent();
        return textFromIFrame;
    }
}
