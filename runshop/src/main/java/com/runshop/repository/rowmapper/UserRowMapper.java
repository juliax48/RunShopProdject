package com.runshop.repository.rowmapper;

import com.runshop.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.runshop.repository.columns.UserColumns.ID;
import static com.runshop.repository.columns.UserColumns.NAME;
import static com.runshop.repository.columns.UserColumns.SURNAME;
import static com.runshop.repository.columns.UserColumns.DATE_BIRTH;
import static com.runshop.repository.columns.UserColumns.WEIGHT;
import static com.runshop.repository.columns.UserColumns.HEIGHT;
@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user;
        try {
            user = new User();
            user.setId(rs.getLong(ID));
            user.setName(rs.getString(NAME));
            user.setSurname(rs.getString(SURNAME));
            user.setDateBirth(rs.getTimestamp(DATE_BIRTH));
            user.setWeight(rs.getDouble(WEIGHT));
            user.setHeight(rs.getDouble(HEIGHT));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
