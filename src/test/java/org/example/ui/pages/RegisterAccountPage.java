package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.data.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
   private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
   private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
   private SelenideElement address = element(Selectors.byId("customer.address.street"));
   private SelenideElement city = element(Selectors.byId("customer.address.city"));
   private SelenideElement state = element(Selectors.byId("customer.address.state"));
   private SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
   private SelenideElement phone = element(Selectors.byId("customer.phoneNumber"));
   private SelenideElement ssn = element(Selectors.byId("customer.ssn"));
   private SelenideElement username = element(Selectors.byId("customer.username"));
   private SelenideElement password = element(Selectors.byId("customer.password"));
   private SelenideElement repeatedPassword = element(Selectors.byId("repeatedPassword"));

    //добавить все важные элементы странички

   private SelenideElement registerButton = element(Selectors.byValue("Register"));

    //Дальше идут элементы ошибок
    SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));

    SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    SelenideElement confirmPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    //Сообщение об успешной регистрации
    SelenideElement successfulMessageTitle = element(Selectors.byXpath("//div[@id='rightPanel']//h1[@class='title']"));
    SelenideElement successfulMessageText = element(Selectors.byXpath("//div[@id='rightPanel']//p"));



    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        firstNameInput.sendKeys(bankAccount.getFirstName() != null ? bankAccount.getFirstName() : "");
        lastNameInput.sendKeys(bankAccount.getLastName() != null ? bankAccount.getLastName() : "");
        address.sendKeys(bankAccount.getAddress() != null ? bankAccount.getAddress() : "");
        city.sendKeys(bankAccount.getCity() != null ? bankAccount.getCity() : "");
        state.sendKeys(bankAccount.getState() != null ? bankAccount.getState() : "");
        zipCode.sendKeys(bankAccount.getZipCode() != null ? bankAccount.getZipCode() : "");
        phone.sendKeys(bankAccount.getPhone() != null ? bankAccount.getPhone() : "");
        ssn.sendKeys(bankAccount.getSsn() != null ? bankAccount.getSsn() : "");
        username.sendKeys(bankAccount.getUsername() != null ? bankAccount.getUsername() : "");
        password.sendKeys(bankAccount.getPassword() != null ? bankAccount.getPassword() : "");
        repeatedPassword.sendKeys(bankAccount.getRepeatedPassword() != null ? bankAccount.getRepeatedPassword() : "");

        registerButton.click();
    }
}
