package com.company.untitled1.security;

import com.company.untitled1.entity.User;
import io.jmix.securityflowui.password.PasswordValidationContext;
import io.jmix.securityflowui.password.PasswordValidationException;
import io.jmix.securityflowui.password.PasswordValidator;

public class MyPasswordValidator implements PasswordValidator<User> {

    @Override
    public void validate(PasswordValidationContext<User> context) throws PasswordValidationException {
        if (context.getPassword().length() < 3)
            throw new PasswordValidationException("Password is too short, must be >= 3 characters");
    }
}
