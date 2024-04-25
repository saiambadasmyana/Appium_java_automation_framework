package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.DriverManager;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Smoke1", plugin = {"pretty", "json:target/cucumber.json", "summary"}, features = {"src/test/resources/features"}, glue = {"stepdefinitions"})
public class RunnerTest {

    public static String Platform = "Android";
    public static String runName;

    public static String getRunDetails(){
        return new Timestamp(new Date().getTime()).toString().replace(":", "-");
    }

    @BeforeClass
    public static void runDetails() {
        runName = getRunDetails();
    }

    public static void closeSession() {
        DriverManager driver = new DriverManager();
        if (driver.getDriver() != null) {
            driver.getDriver().quit();
        }
    }

    @AfterClass
    public static void tearDown() {
        closeSession();
        generateTestReports();
    }

    private static void generateTestReports() {
        File reportOutputDirectory = new File("reports/test-reports/" + runName);
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        String buildNumber = "1.1.0";
        String projectName = "Swagger";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);

        configuration.addClassifications("Tool", "Appium");
        configuration.addClassifications("Platform", "Android");
        configuration.setSortingMethod(SortingMethod.NATURAL);
        configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
        configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();
    }
}
