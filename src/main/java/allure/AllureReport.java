package allure;

import baseTest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Paths;

public class AllureReport extends BaseTest {
    public static Logger LOG = LogManager.getLogger(AllureReport.class);
    public static File srcFolder = new File("/Users/rahilranpura/Desktop/Automation_Practical/allure-report");
    public static String allureGenerate = "allure generate /Users/rahilranpura/Desktop/Automation_Practical/allure-results";
    public String browserVersion = browserVersion();

    public String buildDescription = "WebPageUrl: "+ property.getProperty("url")
            +"\n" + "BrowserName: "+ property.getProperty("browser")
            +"\n" + "BrowserVersion: " + browserVersion;
    public void createFileOfBuildDescription () {
        LOG.info("------- Start Collecting Build Details -------");
        String description = Paths.get(".\\allure-results", "environment.properties").toAbsolutePath().normalize().toString();
        File jenkinsDescriptionFile = new File(description);
        try {
            Writer bw = new BufferedWriter(new FileWriter(jenkinsDescriptionFile));
            bw.write(buildDescription);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startGeneratingAllureReport() {
        createFileOfBuildDescription();
        try {
            LOG.info("------- Serving allure report -------");
            Runtime.getRuntime().exec(allureGenerate);
            new BaseTest().wait(10000);
            LOG.info("------- Generated allure report successfully -------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

