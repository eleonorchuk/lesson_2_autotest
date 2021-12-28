package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    String getCurrnetUrl() {
        return driver.getCurrentUrl();
    }
}
