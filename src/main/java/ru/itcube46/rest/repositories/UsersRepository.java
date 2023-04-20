package ru.itcube46.rest.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.User;

/**
 * Репозиторий - слой приложения, который отвечает за операции над данными.
 * Используется Spring Data JDBC.
 */
public interface UsersRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM USERS WHERE EMAIL = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("UPDATE USERS SET PASSWORD = :token WHERE EMAIL = :email")
    Optional<User> updateToken(@Param("email") String email, @Param("token") String token);

    @Query("SELECT * FROM USERS WHERE ID = :id")
    Optional<User> findUserById(@Param("id") Long id);

    @Query("INSERT INTO users (email, password) VALUES (:email, :token)")
    Optional<User> save(@Param("email") String email, @Param("token") String token);
}