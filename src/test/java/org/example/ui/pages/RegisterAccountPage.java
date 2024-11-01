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




    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());

        registerButton.click();
    }
}
