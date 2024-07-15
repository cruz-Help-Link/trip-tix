package org.dafe.tripTix.service.validators;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class EmailValidator implements Predicate<String> {

    // Regular expression for validating email addresses
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );

    @Override
    public boolean test(String email) {
        // Validate the email against the regex pattern
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
