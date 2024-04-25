package screens;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class BaseScreen {

    public BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(new DriverManager().getDriver()), this);
    }

    public static WebElement withText(String text) {
        return new DriverManager().getDriver().findElement(By.xpath("//android.widget.TextView[@text='" + text + "']"));
    }
}
