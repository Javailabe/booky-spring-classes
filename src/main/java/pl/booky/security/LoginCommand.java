package pl.booky.security;

import lombok.Data;

@Data
class LoginCommand {
    private String username;
    private String password;
}
