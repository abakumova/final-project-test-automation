package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@id='js-voucher-code-text']")
    private WebElement couponCodeInput;

    @FindBy(xpath = "//*[@id='js-voucher-code-text']")
    private WebElement applyButton;

    @FindBy(xpath = "//*[@id='quantity_0']")
    private WebElement qtyInput;

    @FindBy(xpath = "//div[@class='price']")
    private WebElement price;

    @FindBy(xpath = "//div[@class='price price__total']")
    private WebElement total;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterCouponCode(String couponCode) {
        couponCodeInput.clear();
        couponCodeInput.sendKeys(couponCode);
    }

    public void enterQty(String qty) {
        qtyInput.clear();
        qtyInput.sendKeys(qty);
    }

    public String getPriceText() {
        return price.getText();
    }

    public String getTotalText() {
        return total.getText();
    }

    public WebElement getCouponCodeInput() {
        return couponCodeInput;
    }

    public WebElement getApplyButton() {
        return applyButton;
    }

    public WebElement getQtyInput() {
        return qtyInput;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getTotal() {
        return total;
    }
}