package org.dafe.tripTix.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    private int userId;
    private String fullName;
    private String emailAddress;
    private String password;
}
