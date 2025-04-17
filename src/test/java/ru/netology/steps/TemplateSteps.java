package ru.netology.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import ru.netology.data.DataHelper;
import ru.netology.pages.DashboardPage;
import ru.netology.pages.LoginPage;
import ru.netology.pages.TransferPage;
import ru.netology.pages.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private static TransferPage transferPage;

    @Пусть("пользователь залогинен с именем {string} и паролем {string}")
    public void loginUser(String login, String password) {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var user = new DataHelper.AuhtInfo(login, password);
        var verificationPage = loginPage.validLogin(user);
        var verificationCode = getVerificationCode();
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Когда("пользователь переводит {int} рублей с карты с номером {string} на свою {int} карту с главной страницы")
    public void makeTransfer(int amount, String numberCard, int indexCard) {
        var transferPage = dashboardPage.selectedCardTransfer(indexCard);
        var card = DataHelper.getCard(numberCard);
        transferPage.transferFrom(String.valueOf(amount), card);
    }

    @Тогда("баланс его {int} карты из списка на главной странице должен стать {int}")
    public void ActualBalance(int index, int balance) {
        int actualBalance = dashboardPage.getCardBalance(index);
        int expectedBalance = balance;
        Assert.assertEquals(expectedBalance,actualBalance);
    }
}
