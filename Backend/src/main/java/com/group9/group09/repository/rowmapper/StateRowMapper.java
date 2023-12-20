package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.State;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StateRowMapper implements RowMapper<State> {
    @Override
    public State mapRow(ResultSet rs, int rowNum) throws SQLException {
        State state = new State();
        state.setStateID(rs.getInt("state_id"));
        state.setStateName(rs.getString("state"));
        state.setDescription(rs.getString("description"));
        state.setCountryID(rs.getInt("country_id"));
        state.setStateImageLink(rs.getString("stateImageLink"));

        return state;
    }
}
