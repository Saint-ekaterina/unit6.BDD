package ru.netology.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {


    private SelenideElement securityCodeInput = $(".auth-code-input");
    private SelenideElement submitButton = $(".verify-security-code");

    public VerificationPage() {
        securityCodeInput.shouldBe(visible)
                .shouldBe(enabled);
    }


    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        enterVerificationCode(verificationData.getCode());
        submitVerification();
        return new DashboardPage();
    }

    private void enterVerificationCode(String code) {
        securityCodeInput.setValue(code);
    }

    private void submitVerification() {
        submitButton.click();
    }
}
