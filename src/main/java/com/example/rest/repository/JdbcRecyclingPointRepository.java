package com.example.rest.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.rest.entities.RecyclingPoint;

@Repository
public class JdbcRecyclingPointRepository implements RecyclingPointRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcRecyclingPointRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<RecyclingPoint> findAllByCity(String city) {
        List<RecyclingPoint> points = jdbcTemplate.query(
                "SELECT id, city, latitude, longitude, specialization, organization, phone, reception_days FROM recycling_points WHERE city = ?",
                this::mapRowToRecyclingPoint, city);
        return points;
    }

    @Override
    public RecyclingPoint save(RecyclingPoint point) {
        PreparedStatementCreatorFactory psFactory = new PreparedStatementCreatorFactory(
                "INSERT INTO recycling_points (city, latitude, longitude, specialization, organization, phone, reception_days) values (?, ?, ?, ?, ?, ?, ?)",
                Types.VARCHAR, Types.REAL, Types.REAL,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR);
        psFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator psCreator = psFactory.newPreparedStatementCreator(
                Arrays.asList(
                        point.getCity(),
                        point.getLatitude(),
                        point.getLongitude(),
                        point.getSpecialization(),
                        point.getOrganization(),
                        point.getPhone(),
                        point.getReceptionDays()));

        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(psCreator, holder);

        Number key = holder.getKey();
        if (key != null) {
            point.setId(key.intValue());
        }
        return point;
    }

    private RecyclingPoint mapRowToRecyclingPoint(ResultSet row, int rowNumber) throws SQLException {
        return new RecyclingPoint(
                row.getInt("id"),
                row.getString("city"),
                row.getDouble("latitude"),
                row.getDouble("longitude"),
                row.getString("specialization"),
                row.getString("organization"),
                row.getString("phone"),
                row.getString("reception_days"));
    }
}
