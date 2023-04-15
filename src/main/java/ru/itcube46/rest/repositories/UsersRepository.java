package ru.itcube46.rest.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM USERS WHERE EMAIL = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query("SELECT * FROM USERS WHERE EMAIL = :email AND PASSWORD = :pw")
    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("pw") String password);
}
