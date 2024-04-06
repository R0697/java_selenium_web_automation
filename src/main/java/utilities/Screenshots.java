package utilities;

import baseTest.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots extends BaseTest {

    public File takeScreenshot() {
        TakesScreenshot ts = ((TakesScreenshot) driver);
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        String destination = "/Users/rahilranpura/Desktop/Automation_Practical/screenshots/"+dateName+".png";
        File targetFile = new File(destination);

        try {
            FileHandler.copy(srcFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return srcFile;
    }
}
