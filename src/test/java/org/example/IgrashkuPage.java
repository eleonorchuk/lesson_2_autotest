package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IgrashkuPage extends AbstractPage {

    @FindBy(xpath = "//a[@href=\"/ukr/help/contacts/\"and@ class=\"linkJ\"]")
    private WebElement kontakti;
    @FindBy(xpath = "//a[@ href=\"/ukr/help/how_to_order/\"and@ class=\"linkJ\"]")
    private WebElement howToOrder;
    @FindBy(xpath = "//button[@ id=\"btnNovaUkr\"]")
    private WebElement button;
    @FindBy(xpath =  "//a[@id=\"571383/3\"]")
    private WebElement toy;


    IgrashkuPage(String page) {
        super(page);
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
