package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
       Country country = new Country();

       country.setCountryID(rs.getInt("country_id"));
       country.setCountryName(rs.getString("country_name"));
       country.setDescription(rs.getString("description"));
       country.setCountryImageLink(rs.getString("countryImageLink"));

       return country;
    }
}
