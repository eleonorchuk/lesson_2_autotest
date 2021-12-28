package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static Logger logger = LoggerFactory.getLogger(AppTest.class);
    protected WebDriver driver;
    /**
     * Rigorous Test :-)
     */
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // Click Kontakti
    @Test
    public void scenario1Test() {
        IgrashkuPage ip = new IgrashkuPage(driver);
        IgrashkuPage kontakti = ip.clickKontakti();

        assertNotNull(kontakti);
        assertTrue(kontakti.getCurrnetUrl().equals("https://bi.ua/ukr/help/contacts/"));
    }

    // Click Oplata i Dostavka
    @Test
    public void scenario2Test() {
        IgrashkuPage ip = new IgrashkuPage(driver);
        IgrashkuPage order = ip.clickHowToOrder();
        assertNotNull(order);
        assertTrue(order.getCurrnetUrl().equals("https://bi.ua/ukr/help/how_to_order/"));
    }

    // Show Nova Pochta details
    @Test
    public void scenario3Test() {
        IgrashkuPage ip = new IgrashkuPage(driver);
        assertNotNull(ip.howToOrder);
        IgrashkuPage order = ip.clickHowToOrder();
        assertNotNull(order);
        IgrashkuPage btn = order.clickButton();
        assertNotNull(btn);
        assertTrue(btn.getCurrnetUrl().equals("https://bi.ua/ukr/help/how_to_order/"));
    }

    @Test
    public void scenario4Test() {
        IgrashkuPage ip = new IgrashkuPage(driver);
        try {
            assertTrue(ip.clickToy().getCurrnetUrl().equals("https://bi.ua/ukr/product/figurka-novogodko-olen-svetlo-seryy-973993.html"));
        } catch (NoSuchElementException e) {
            assertTrue(false);
        }
    }

    @BeforeEach
    public void initDriver() {
        Cookie cookie;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://bi.ua/");
        cookie = driver.manage().getCookieNamed("testing");
        if (cookie == null)
            driver.manage().addCookie(new Cookie("testing", "test"));

        driver.manage().window().setSize(new Dimension(1386, 700));
    }

    @AfterEach
    public void tearDown() {
        // Вывод всех ошибок браузера после каждого теста
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (allLogRows.size() > 0 ) {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("browser.log"), "utf-8"))) {
                writer.write(allLogRows.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // -------------------------------
        driver.quit();
    }
}
