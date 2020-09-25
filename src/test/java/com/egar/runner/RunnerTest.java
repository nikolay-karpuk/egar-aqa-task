package com.egar.runner;


import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/com/egar/features",
        glue = "com/egar/steps",
        tags = "@smoketest")


public class RunnerTest {
    @BeforeClass
    static public void setupTimeout()
    {
        Configuration.timeout = 1000;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browser = "chrome"; //Версия 85.0.4183.121 (Официальная сборка), (64 бит)
    }

    @Before
    public void clearCache() {
        clearBrowserCache();
    }

}
