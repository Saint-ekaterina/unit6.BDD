package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement header = $("[data-test-id='dashboard']");
    private SelenideElement amount = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement button = $("[data-test-id='action-transfer']");

    public TransferPage () {
        header.should(visible);
    }

    public void transferFrom(String transferAmount, DataHelper.CardInfo cardInfo) {
        amount.setValue(transferAmount);
        from.setValue(cardInfo.getCardNumber());
        button.click();
    }
}
