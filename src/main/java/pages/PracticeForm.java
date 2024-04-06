package pages;

import baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PracticeForm extends BaseTest {

    public String headingOfPageLocator = "//*[contains(text(), 'Selenium - Automation Practice Form')]";
    public String studentRegistrationTitleLocator = "//*[text()='Student Registration Form']";
    public String firstNameTextFieldLocator = "//input[@id='name']";
    public String emailTextFieldLocator = "//input[@id='email']";
    public String maleGenderRadioButton = "//input[@id='gender']";
    public String phoneNumberLocator = "//input[@id='mobile']";
    public String dateOfBirthLocator = "//input[@id='dob']";
    public String subjectsLocator = "//input[@id='subjects']";
    public String hobbiesSportsLocator = "//input[@type='checkbox' and @id='hobbies']";
    public String currentAddressLocator = "//textarea[@id='picture']";
    public String chooseStateLocator = "state";
    public String chooseStateLocatorXpath = "//select[@id='state']";
    public String chooseCityLocatorXpath = "//select[@id='city']";
    public String chooseCityLocator = "city";
    public String loginButtonLocator = "//input[@type='submit']";
    public String practiceFormLocator = "//*[contains(@href, 'selenium_automation_practice.php')]";
    public String chooseButtonLocator = "//input[@id='picture' and @type='file']";
    public String firstNameGetTextLocator = "name";


    // Method to verify the element is Displayed
    public boolean isElementDisplayed(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    // Method to verify element is selected
    public boolean isElementSelected(String xpath)
    {
        return driver.findElement(By.xpath(xpath)).isSelected();
    }

    // Click on Element method
    public void clickOnElement(String xpath)
    {
        driver.findElement(By.xpath(xpath)).click();
    }

    // To enter text in text fields
    public void enterText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    // Click and Enter text method
    public void clickOnElementAndEnterText(String xpath, String text) {
        clickOnElement(xpath);
        enterText(xpath, text);
    }

    // Get text from element by passing the web element
    public String getTextFromElement(String method, String locator) {
        String text = null;
        if(method.equalsIgnoreCase("id")){
            text = driver.findElement(By.id(locator)).getText();
        } else if (method.equalsIgnoreCase("xpath")) {
            text = driver.findElement(By.xpath(locator)).getText();
        }
        return text;
    }

    // Wait method for element visibility
    public void waitForElementAppear(String xpath, int maxTime)
    {
        int i = 0;
        try{
            while(i<maxTime)
            {
                isElementDisplayed(xpath);
                sleep(1000);
                i++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElement(String xpath, int max_time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(max_time));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void selectValueFromDropDown(String id, String value) {
        WebElement selectDropDown = driver.findElement(By.id(id));
        Select selectOptions = new Select(selectDropDown);
//        List<WebElement> allOptions = driver.findElements(By.id(id));
        List<WebElement> allOptions = selectOptions.getOptions();
        for (WebElement option: allOptions) {
            if(option.getText().equalsIgnoreCase(value)) {
                System.out.println("Selected Value: " + option.getText());
                option.click();
            }
        }
    }

    public void fileUpload(String xpath, String uploadingFilePath) {
        driver.findElement(By.xpath(xpath)).sendKeys(uploadingFilePath);
    }



}
