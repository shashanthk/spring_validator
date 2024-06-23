package com.shashanth.spring.validator.model;

import com.shashanth.spring.validator.validators.*;
import lombok.Data;

@Data
public class User {

    @AlphabetsOnly
    private String firstName;
    @AlphabetsOnly(regex = "^[A-Z]$", message = "Last name should contain only upper case letters")
    private String lastName;
    @AlphaNumericOnly
    private String userId;
    @EmailOnly
    private String email;
    @DateOnly(message = "Date should be in yyyy-MM-dd format")
    private String date;
    @TimeOnly(message = "Time should be in HH:mm:ss format")
    private String time;
}
