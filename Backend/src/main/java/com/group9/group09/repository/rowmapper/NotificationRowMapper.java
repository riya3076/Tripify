package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.Notification;
import com.group9.group09.model.Place;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationRowMapper implements RowMapper<Notification> {

    @Override
    public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
        Notification notification = new Notification();

        notification.setCategory(rs.getString("category"));
        notification.setId(rs.getInt("id"));
        notification.setDescription(rs.getString("description"));
        notification.setUserId(rs.getInt("user_id"));

        return notification;
    }
}
