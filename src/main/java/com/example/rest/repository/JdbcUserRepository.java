package com.example.rest.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.rest.entities.User;

@Repository
public class JdbcUserRepository implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByNameAndPassword(String name, String password) {
        List<User> users = jdbcTemplate.query(
                "SELECT id, login, password, score FROM users WHERE login = ? AND password = ?",
                this::mapRowToUser,
                name,
                password);
        return (users.size() == 0) ? Optional.empty() : Optional.of(users.get(0));
    }

    @Override
    public User save(User user) {
        PreparedStatementCreatorFactory psFactory = new PreparedStatementCreatorFactory(
                "INSERT INTO users (login, password) values (?, ?)",
                Types.VARCHAR, Types.VARCHAR);
        psFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psCreator = psFactory.newPreparedStatementCreator(
                Arrays.asList(user.getLogin(), user.getPassword()));

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(psCreator, holder);

        Number key = holder.getKey();
        if (key != null) {
            user.setId(key.intValue());
        }
        return user;
    }

    private User mapRowToUser(ResultSet row, int rowNumber) throws SQLException {
        return new User(row.getInt("id"),
                row.getString("login"),
                row.getString("password"),
                row.getInt("score"));
    }
}
