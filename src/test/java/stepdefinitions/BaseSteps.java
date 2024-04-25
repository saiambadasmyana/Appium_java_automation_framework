package stepdefinitions;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.RunnerTest;
import utils.DriverManager;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

public class BaseSteps {

    public static void waitUntilViewDisplayed(WebElement e) {
        WebDriverWait wait = new WebDriverWait(new DriverManager().getDriver(), Duration.ofMillis(30000));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public static void waitAndClick(WebElement e) {
        waitUntilViewDisplayed(e);
        e.click();
    }

    public static void enterText(WebElement e, String text) {
        waitUntilViewDisplayed(e);
        e.sendKeys(text);
    }

    public static String getText(WebElement e) {
        waitUntilViewDisplayed(e);
        return e.getText();
    }

    public void scrollUntilViewDisplayed(WebElement e, String direction) {
        int i = 0;
        do {
            try {
                boolean elementStatus = e.isDisplayed();
                if (elementStatus) {
                    break;
                }
            } catch (NoSuchElementException er) {
                i++;
                swipe(direction);
            }
        } while (i < 3);
    }

    public void swipe(String Direction) {
        Dimension size = new DriverManager().getDriver().manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = 0;
        if (Direction.equalsIgnoreCase("up")) {
            endY = (int) (size.getHeight() * 0.25);
        } else if (Direction.equalsIgnoreCase("down")) {
            endY = (int) (size.getHeight() * 0.75);
        } else {
            Assert.fail("Invalid direction");
        }

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(500)))
                .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endX,
                        endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        new DriverManager().getDriver().perform(Collections.singletonList(sequence));
    }

    public static void getScreenshot() throws IOException {
        File file = new DriverManager().getDriver().getScreenshotAs(OutputType.FILE);
        File newFile = new File(System.getProperty("user.dir") + "/reports/screenShots/" + RunnerTest.runName + File.separator + RunnerTest.getRunDetails() + ".jpg");
        FileUtils.copyFile(file, newFile);
    }
}
