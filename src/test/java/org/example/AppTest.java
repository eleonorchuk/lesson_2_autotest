package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
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
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickKontakti().getCurrnetUrl().equals("https://bi.ua/ukr/help/contacts/"));
        driver = ip.getDriver();
    }

    // Click Oplata i Dostavka
    @Test
    public void scenario2Test() {
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickHowToOrder().getCurrnetUrl().equals("https://bi.ua/ukr/help/how_to_order/"));
        driver = ip.getDriver();
    }

    // Show Nova Pochta details
    @Test
    public void scenario3Test() {
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickHowToOrder().clickButton().getCurrnetUrl().equals("https://bi.ua/ukr/help/how_to_order/"));
        driver = ip.getDriver();
    }

    @Test
    public void scenario4Test() {
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickToy().getCurrnetUrl().equals("https://bi.ua/ukr/product/figurka-novogodko-olen-svetlo-seryy-973993.html"));
        driver = ip.getDriver();
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
