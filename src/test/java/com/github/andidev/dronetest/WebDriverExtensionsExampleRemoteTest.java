package com.github.andidev.dronetest;

import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.*;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(WebDriverRunner.class)
@Firefox
@Chrome
@InternetExplorer
@DriverPaths
@RemoteAddress("http://andidev:80b7768e-dc06-4d5b-b793-5b3b83f0e24c@ondemand.saucelabs.com:80/wd/hub")
public class WebDriverExtensionsExampleRemoteTest {

    // Model
    @FindBy(name = "q")
    WebElement queryInput;
    @FindBy(name = "btnG")
    WebElement searchButton;
    @FindBy(id = "search")
    WebElement searchResult;

    @Test
    public void searchGoogleForHelloWorldTest() {
        open("http://www.google.com");
        assertCurrentUrlContains("google");

        type("Hello World", queryInput);
        click(searchButton);

        waitFor(3, SECONDS);
        assertTextContains("Hello World", searchResult);
    }
}
