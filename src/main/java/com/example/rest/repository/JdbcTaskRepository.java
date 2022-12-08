package com.example.rest.repository;

import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.rest.entities.Task;

@Repository
public class JdbcTaskRepository implements TaskRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Task> findAllByUserId(int userId) {
        List<Task> tasks = jdbcTemplate.query(
                "SELECT id, user_id, title, description, date_of_creation, date_of_completion FROM tasks WHERE user_id = ?",
                this::mapRowToTask, userId);
        return tasks;
    }

    @Override
    public Task save(Task task) {
        PreparedStatementCreatorFactory psFactory = new PreparedStatementCreatorFactory(
                "INSERT INTO tasks (user_id, title, description, date_of_creation, date_of_completion) values (?, ?, ?, ?, ?)",
                Types.INTEGER, Types.VARCHAR, Types.VARCHAR);
        psFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psCreator = psFactory.newPreparedStatementCreator(
                Arrays.asList(
                        task.getUserId(),
                        task.getTitle(),
                        task.getDescription(),
                        new Timestamp(task.getDateOfCreation().getTime()),
                        (task.getDateOfCompletion() == null) ? null
                                : new Timestamp(task.getDateOfCompletion().getTime())));

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(psCreator, holder);

        task.setId(holder.getKey().intValue());
        return task;
    }

    private Task mapRowToTask(ResultSet row, int rowNumber) throws SQLException {
        return new Task(
                row.getInt("id"),
                row.getString("coords_latitude"),
                row.getString("coords_longitude"),
                row.getString("organisation"),
                row.getInt("number"));
    }
}
