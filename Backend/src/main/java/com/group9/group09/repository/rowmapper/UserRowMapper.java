package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("userid"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("contact_no"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setHomeCountry(rs.getInt("homeCountry"));
        user.setInterest(rs.getString("interest"));
        user.setIsAdmin(rs.getInt("isAdmin"));

        return user;
    }
}
