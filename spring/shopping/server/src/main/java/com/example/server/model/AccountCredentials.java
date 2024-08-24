package com.example.server.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AccountCredentials {
    private final String username;
    private final String password;
}
