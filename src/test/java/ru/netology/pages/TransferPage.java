package ru.netology.pages;



import com.codeborne.selenide.SelenideElement;
import com.banking.data.BankCard;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class TransferPage {

    // Элементы страницы
    private SelenideElement pageHeader = $("[data-test-id='dashboard']");
    private SelenideElement amountInput = $("[data-test-id='amount'] input");
    private SelenideElement cardNumberInput = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    // Проверяем, что страница загрузилась
    public TransferPage() {
        pageHeader.shouldBe(visible, Duration.ofSeconds(5));
    }

    /**
     * Выполняет перевод денег с указанной карты
     *
     * @param amount Сумма перевода (например, "5000")
     * @param sourceCard Данные карты, с которой выполняется перевод
     */
    public void makeTransfer(String amount, BankCard sourceCard) {
        amountInput.setValue(amount);
        cardNumberInput.setValue(sourceCard.getCardNumber());
        transferButton.click();
    }
}



