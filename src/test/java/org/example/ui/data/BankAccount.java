package org.example.ui.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private int phone;
    private int ssn;
    private String username;
    private String password;
    private String repeatedPassword;

}
