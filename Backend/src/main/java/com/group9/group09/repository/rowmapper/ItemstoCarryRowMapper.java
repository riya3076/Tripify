package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.ItemstoCarry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemstoCarryRowMapper implements RowMapper<ItemstoCarry> {
    @Override
    public ItemstoCarry mapRow(ResultSet rs, int rowNum) throws SQLException {

        ItemstoCarry itemstoCarry = new ItemstoCarry();
        itemstoCarry.setItemID(rs.getInt("item_id"));
        itemstoCarry.setItemName(rs.getString("item_name"));

        return itemstoCarry;
    }
}
