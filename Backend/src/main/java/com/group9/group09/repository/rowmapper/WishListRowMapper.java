package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.wishList;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WishListRowMapper implements RowMapper<wishList> {

    @Override
    public wishList mapRow(ResultSet rs, int rowNum) throws SQLException {

       wishList wishList = new wishList();
       wishList.setWishListID(rs.getInt("wishlist_id"));
       wishList.setPlaceID(rs.getInt("city_id"));
       wishList.setActivityID(rs.getInt("activity_id"));
       wishList.setUserID(rs.getInt("user_id"));
       wishList.setPlaceID(rs.getInt("place_id"));

       return wishList;
    }
}
