package org.example;

import com.codeborne.selenide.*;
import org.example.ui.data.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleUITest {
    @BeforeAll
    public static void setUpUITest() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        //Configuration.timeout = 10;
    }

    //ПРИНЦИПЫ
    //DRY =Dont repeat yourself
    //Веб элементы не ищутся в тесте, они ищутся в PAGE OBJECT классе.
    //Автотест сам создает рандомизированные данные для себя

    @Test
    public void userCanNotCreateAccountWithNameAndSurname() {
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        //Шаги теста
       registerAccountPage.register(bankAccount);

        //Проверка ожидаемого поведения

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getConfirmPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanCreateAccount() {

    }
}
