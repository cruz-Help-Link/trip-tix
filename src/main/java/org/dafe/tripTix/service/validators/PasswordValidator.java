package org.dafe.tripTix.service.validators;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class PasswordValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return true;
    }
}
