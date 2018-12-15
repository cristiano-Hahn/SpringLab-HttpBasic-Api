package com.example.security.repository.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AccountCreateDto implements Serializable {

    private String username;

    private String password;
}
