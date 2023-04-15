package ru.itcube46.rest.configurations;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ru.itcube46.rest.entities.User;
import ru.itcube46.rest.repositories.UsersRepository;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Надежное шифрование паролей алгоритмом bcrypt
        // return new BCryptPasswordEncoder();

        // На этапе отладки шифрование паролей полностью отключено
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService(UsersRepository usersRepository) {
        return email -> {
            Optional<User> user = usersRepository.findByEmail(email);
            return user.orElseThrow(() -> new UsernameNotFoundException("Пользователь " + email + " не найден"));
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((requests) -> requests
                        //.requestMatchers("api/posts", "api/posts/**", "api/comments", "api/comments/**").hasRole("USER")
                        .anyRequest().permitAll());
        return httpSecurity.build();
    }
}
