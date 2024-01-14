package com.example.studioVogue.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String userName;
    private String password;
}
