package pl.booky.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.booky.users.db.UserEntityRepository;

@AllArgsConstructor
public class BookyUserDetailsService implements UserDetailsService {

    private final UserEntityRepository repository;
    private final AdminConfig config;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (config.getUserName().equalsIgnoreCase(username)) {
            return config.adminUser();
        }
        return repository.findByUsernameIgonoreCase(username)
                .map(UserEntityDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}