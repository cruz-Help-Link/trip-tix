package org.dafe.tripTix.mapper;

import org.dafe.tripTix.dto.SignUpDto;
import org.dafe.tripTix.entity.SignUp;

public class SignUpMapper {

    public static SignUpDto maptoSignUpDto(SignUp signUp){

        return new SignUpDto(
                signUp.getUserId(),
                signUp.getFullName(),
                signUp.getEmailAddress(),
                signUp.getPassword()

        );



    }

    public static SignUpDto maptoSignUpEntity(SignUpDto signUpDto){

        return new SignUpDto(
                signUpDto.getUserId(),
                signUpDto.getFullName(),
                signUpDto.getEmailAddress(),
                signUpDto.getPassword()

        );



    }

}
