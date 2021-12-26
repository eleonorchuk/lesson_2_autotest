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
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickKontakti().getCurrnetUrl().equals("https://bi.ua/ukr/help/contacts/"));
        ip.close();
    }

    // Click Oplata i Dostavka
    @Test
    public void scenario2Test() {
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickHowToOrder().getCurrnetUrl().equals("https://bi.ua/ukr/help/how_to_order/"));
        ip.close();
    }

    // Show Nova Pochta details
    @Test
    public void scenario3Test() {
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickHowToOrder().clickButton().getCurrnetUrl().equals("https://bi.ua/ukr/help/how_to_order/"));
        ip.close();
    }

    @Test
    public void scenario4Test() {
        IgrashkuPage ip = new IgrashkuPage("https://bi.ua/");
        assertTrue(ip.clickToy().getCurrnetUrl().equals("https://bi.ua/ukr/product/figurka-novogodko-olen-svetlo-seryy-973993.html"));
        ip.close();
    }
}
