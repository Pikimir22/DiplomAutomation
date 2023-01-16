package settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import components.SearchNegative;
import components.SearchPositive;
import helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    public RandomUtils randomUtils = new RandomUtils();
    public SearchPositive findElements = new SearchPositive();
    public SearchNegative searchNegative = new SearchNegative();

    @Step("Подготовка")
    @BeforeAll
    static void setup() {
        new ChromeOptions().addArguments("start-maximized");
        Configuration.baseUrl = ("https://ai.sber.ru");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1320x800");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");
        Configuration.pageLoadTimeout = 60000;
        Configuration.timeout = 9000;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("acceptInsecureCerts", false);
        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        Configuration.browserCapabilities = capabilities;

    }

    @Step("Добавить логгер")
    @BeforeEach
    void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Step("Добавить вложения")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
