package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App 
{
    public static void main(String[] args) {
        scenario1();
        scenario2();
        scenario3();
    }

    // Click Kontakti
    public static void scenario1() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@href=\"/ukr/help/contacts/\"and@ class=\"linkJ\"]"
        ));
        webElement.click();
        driver.close();
    }

    // Click Oplata i Dostavka
    public static void scenario2() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@ href=\"/ukr/help/how_to_order/\"and@ class=\"linkJ\"]"
        ));
        webElement.click();

    }

    // Show Nova Pochta details
    public static void scenario3() {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.get("https://bi.ua/");
        driver.manage().window().setSize(new Dimension(1386, 700));
        WebElement webElement = driver.findElement(By.xpath(
                "//a[@ href=\"/ukr/help/how_to_order/\"and@ class=\"linkJ\"]"
        ));
        webElement.click();

        WebElement novPochtaElem = driver.findElement(By.xpath( "//button[@ id=\"btnNovaUkr\"]"));
        novPochtaElem.click();

    }
}

