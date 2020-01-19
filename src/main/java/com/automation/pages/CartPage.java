package com.automation.pages;

import com.automation.waiter.Wait;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Getter
public class CartPage extends BasePage {

    @FindBy(xpath = "//*[@id='js-voucher-code-text']")
    private TextInput couponCodeInput;

    @FindBy(xpath = "//*[@id='js-voucher-code-text']")
    private Button applyButton;

    @FindBy(xpath = "//*[@id='quantity_0']")
    private TextInput qtyInput;

    @FindBy(xpath = "//div[@class='price']")
    private TextBlock price;

    @FindBy(xpath = "//div[@class='price price__total']")
    private TextBlock total;

    public CartPage() {
        super(() -> Wait.untilAppear(By.xpath("//*[@id='js-voucher-code-text']"), 20));
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
}