package ru.itcube46.rest.configurations;

import java.util.Optional;

import org.springframework.context.annotation.Bean;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;
import ru.itcube46.rest.entities.User;
import ru.itcube46.rest.repositories.UsersRepository;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Надежное шифрование паролей алгоритмом bcrypt
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info(encoder.encode("password"));
        return encoder;
    }

    @Bean
    public UserDetailsService userDetailsService(UsersRepository usersRepository) {
        // Доступ к хранилищу учётных записей пользователей для их аутентификации
        return email -> {
            Optional<User> user = usersRepository.findByEmail(email);
            return user.orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + email));
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Настройки безопасности HTTP-запросов
        return http
                .httpBasic(withDefaults())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("api/posts/**", "api/comments/**").hasRole("USER")
                        .anyRequest().permitAll())
                .csrf(csrf -> csrf.disable())
                .headers(h -> h.frameOptions().disable())
                .build();
    }
}
