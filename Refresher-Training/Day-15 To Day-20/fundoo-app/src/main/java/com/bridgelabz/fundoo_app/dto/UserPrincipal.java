package com.bridgelabz.fundoo_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserPrincipal {
    private final Integer userId;
    private final String email;
}
