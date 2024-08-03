package com.coinApp.util;


import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidationUtil {
    public boolean isValidUsername(String username) {
        return Pattern.matches("^[a-zA-Z0-9]{4,15}$", username);
    }

    public boolean isValidPassword(String password) {
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$", password);
    }
}
