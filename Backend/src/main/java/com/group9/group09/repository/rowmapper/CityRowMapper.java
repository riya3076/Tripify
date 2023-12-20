package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City city = new City();
        city.setCityId(Integer.valueOf(rs.getString("City_ID")));
        city.setCityName(rs.getString("city"));
        city.setStateId(Integer.valueOf(rs.getString("state_id")));
        city.setDescription(rs.getString("description"));
        city.setCityImageLink(rs.getString("cityImageLink"));

        return city;
    }
}
