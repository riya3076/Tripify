package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.Itinerary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItineraryRowMapper implements RowMapper<Itinerary> {
    @Override
    public Itinerary mapRow(ResultSet rs, int rowNum) throws SQLException {

        Itinerary itinerary = new Itinerary();
        itinerary.setUserid(rs.getInt("user_id"));
        itinerary.setItineraryid(rs.getInt("itinerary_id"));
        itinerary.setStartdate(rs.getString("start_date"));
        itinerary.setEndDate(rs.getString("end_date"));
        itinerary.setTitle(rs.getString("title"));

        return itinerary;
    }
}
