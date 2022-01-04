package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IgrashkuPage extends AbstractPage {

    @FindBy(xpath = "//a[@href=\"/ukr/help/contacts/\"and@ class=\"linkJ\"]")
    public WebElement kontakti;
    @FindBy(xpath = "//a[@ href=\"/ukr/help/how_to_order/\"and@ class=\"linkJ\"]")
    public WebElement howToOrder;
    @FindBy(xpath = "//button[@ id=\"btnNovaUkr\"]")
    public WebElement button;
    @FindBy(xpath =  "//a[@id=\"528686/2\"]")
    public WebElement toy;


    IgrashkuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public IgrashkuPage clickKontakti() {
        kontakti.click();
        return this;
    }
    public IgrashkuPage clickHowToOrder() {
        howToOrder.click();
        return this;
    }
    public IgrashkuPage clickButton() {
        button.click();
        return this;
    }
    public IgrashkuPage clickToy() {
        toy.click();
        return this;
    }
}
