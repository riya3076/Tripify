package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.Activity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper<Activity> {
    @Override
    public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Activity activity = new Activity();
        activity.setActivityId(rs.getInt("activity_id"));
        activity.setActivityName(rs.getString("activity_name"));
        activity.setDescription(rs.getString("description"));
        activity.setPlaceId(rs.getInt("place_id"));
        activity.setCityId(rs.getInt("city_id"));
        activity.setReviews(rs.getString("reviews"));
        activity.setInterest(rs.getString("interest"));
        activity.setActivityImageLink(rs.getString("activityImageLink"));

        return activity;
    }
}
