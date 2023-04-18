package ru.itcube46.rest.entities;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Класс пользователя.
 * Для генерации геттеров/сеттеров/конструкторов используется Lombok.
 * Для отображения объекта пользователя в запись таблицы БД используется
 * Spring Data JDBC.
 */
@Data
@AllArgsConstructor
@Table("USERS")
public class User implements UserDetails {
    @Id
    private Long id;

    private String email;

    private String password;

    private String username;

    private Integer age;

    private Integer scores;

    /*
     * Методы интерфейса UserDetails с простыми реализациями:
     * все пользователи активны и имеют привилегию ROLE_USER.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
