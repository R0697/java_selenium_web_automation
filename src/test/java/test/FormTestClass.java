package test;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.PracticeForm;
import pages.WindowsAlertsFrames;
import utilities.Listners;

@Listeners(Listners.class)
public class FormTestClass extends BaseTest {

    public String insertFirstName = property.getProperty("name");
    public String email = property.getProperty("email");
    public String phoneNumber = property.getProperty("number");
    public String address = property.getProperty("address");
    public String dob = property.getProperty("dob");
    public String fileUploadPath = property.getProperty("fileUploadPath");
    public String subject = property.getProperty("subject");
    public PracticeForm practiceForm = new PracticeForm();
    public WindowsAlertsFrames windows = new WindowsAlertsFrames();


    @Test(description = "Verify the heading of the page")
    public void VerifyTheHeadingOfPage() {
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.headingOfPageLocator),
                "Heading of the page is not available");
    }

    @Test(description = "Verify all elements are present on the form")
    public void VerifyAllTheElementsAreAvailableInForm() {

        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.studentRegistrationTitleLocator),
                "Student Registration Title is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.firstNameTextFieldLocator),
                "First Name text field is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.emailTextFieldLocator),
                "Email text field is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.phoneNumberLocator),
                "Phone Number text field is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.dateOfBirthLocator),
                "Date of birth is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.subjectsLocator),
                "Subjects text field is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.currentAddressLocator),
                "Current Address text field is not available on the page");
        windows.scrollPageWhileElementNotAppear(practiceForm.loginButtonLocator);
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.chooseCityLocatorXpath),
                "Choose City drop down is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.chooseStateLocatorXpath),
                "Choose State drop down is not available on the page");
        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.loginButtonLocator),
                "Login Button is not available on the page");
    }

    @Test(description = "Enter details in each fields")
    public void EnterAllDetails() {

        Assert.assertTrue(practiceForm.isElementDisplayed(practiceForm.practiceFormLocator),
                "Practice Form is not selected");
        practiceForm.clickOnElementAndEnterText(practiceForm.firstNameTextFieldLocator, insertFirstName);
        practiceForm.clickOnElementAndEnterText(practiceForm.emailTextFieldLocator, email);
        practiceForm.clickOnElement(practiceForm.maleGenderRadioButton);
        practiceForm.clickOnElementAndEnterText(practiceForm.phoneNumberLocator, phoneNumber);
        practiceForm.clickOnElementAndEnterText(practiceForm.dateOfBirthLocator, dob);
        practiceForm.clickOnElementAndEnterText(practiceForm.subjectsLocator, subject);
        practiceForm.clickOnElement(practiceForm.hobbiesSportsLocator);
        practiceForm.fileUpload(practiceForm.chooseButtonLocator, fileUploadPath);
        practiceForm.clickOnElementAndEnterText(practiceForm.currentAddressLocator, address);
        practiceForm.selectValueFromDropDown(practiceForm.chooseStateLocator, "Uttar Pradesh");
        practiceForm.selectValueFromDropDown(practiceForm.chooseCityLocator, "Lucknow");
        practiceForm.clickOnElement(practiceForm.loginButtonLocator);
    }
}
