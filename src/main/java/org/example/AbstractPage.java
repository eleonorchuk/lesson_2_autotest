package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected Cookie cookie;

    AbstractPage(String page)
    {
        /*
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );*/
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(page);
        cookie = driver.manage().getCookieNamed("testing");
        if (cookie == null)
            driver.manage().addCookie(new Cookie("testing", "test"));

        driver.manage().window().setSize(new Dimension(1386, 700));
    }

    String getCurrnetUrl() {
        return driver.getCurrentUrl();
    }

    void close() {
        driver.close();
    }
}
