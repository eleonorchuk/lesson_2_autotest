package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static Logger logger = LoggerFactory.getLogger(AppTest.class);
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // Click Kontakti
    @Test
    public void scenario1Test() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        Cookie cookie = driver.manage().getCookieNamed("testing");
        if (cookie == null)
            driver.manage().addCookie(new Cookie("testing", "test"));

        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@href=\"/ukr/help/contacts/\"and@ class=\"linkJ\"]"
        ));
        webElement.click();
        String url = driver.getCurrentUrl();
        assertTrue(url.equals("https://bi.ua/ukr/help/contacts/"));
        driver.close();
    }

    // Click Oplata i Dostavka
    @Test
    public void scenario2Test() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        Cookie cookie = driver.manage().getCookieNamed("testing");
        if (cookie == null)
            driver.manage().addCookie(new Cookie("testing", "test"));

        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@ href=\"/ukr/help/how_to_order/\"and@ class=\"linkJ\"]"
        ));
        webElement.click();
        String url = driver.getCurrentUrl();
        assertTrue(url.equals("https://bi.ua/ukr/help/how_to_order/"));
        driver.close();
    }

    // Show Nova Pochta details
    @Test
    public void scenario3Test() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        Cookie cookie = driver.manage().getCookieNamed("testing");
        if (cookie == null)
            driver.manage().addCookie(new Cookie("testing", "test"));

        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@ href=\"/ukr/help/how_to_order/\"and@ class=\"linkJ\"]"
        ));
        webElement.click();

        WebElement novPochtaElem = driver.findElement(By.xpath( "//button[@ id=\"btnNovaUkr\"]"));
        novPochtaElem.click();
        String url = driver.getCurrentUrl();
        assertTrue(url.equals("https://bi.ua/ukr/help/how_to_order/"));
        driver.close();
    }

    // ?
    @Test
    public void scenario4Test() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        Cookie cookie = driver.manage().getCookieNamed("testing");
        if (cookie == null)
            driver.manage().addCookie(new Cookie("testing", "test"));

        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@id=\"571345/1\"]"
        ));
        webElement.click();
        String url = driver.getCurrentUrl();
        assertTrue(url.equals("https://bi.ua/ukr/product/elochnaya-igrushka-novogodko-gnom-podveska-s-led-13-sm-974192.html"));
        driver.close();
    }
}
