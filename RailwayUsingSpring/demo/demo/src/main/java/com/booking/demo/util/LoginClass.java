package com.booking.demo.util;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;
@ToString
@Getter
@Component
public class LoginClass {
    @Email
    private String userEmail;
    private String password;
}
