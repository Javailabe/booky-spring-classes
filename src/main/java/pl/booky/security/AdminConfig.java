package pl.booky.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@ConfigurationProperties("app.security.admin")
public class AdminConfig {
    private String userName;
    private String password;
    private Set<String> roles;

    User adminUser() {
        return new User(
                userName,
                password,
                roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet())
        );
    }
}
