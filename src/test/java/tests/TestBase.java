package tests;

import com.codeborne.selenide.Configuration;
import config.Config;
import helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Config config = ConfigFactory.create(Config.class, System.getProperties());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.version();
        Configuration.browserSize = config.size();
        Configuration.remote = config.remoteUrl();
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments(){
        Attach.screenShotAs("Last screenshot");
        if (!Configuration.browser.equalsIgnoreCase("firefox")){
            Attach.browserConsoleLogs();
        }
        Attach.pageSource();
        Attach.addVideo();

        closeWebDriver();
    }
}