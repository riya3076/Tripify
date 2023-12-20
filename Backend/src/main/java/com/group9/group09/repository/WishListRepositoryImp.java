package com.group9.group09.repository;

import com.group9.group09.DTO.RequestDTO.WishListRequestDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.WishlistNotFoundException;
import com.group9.group09.model.wishList;
import com.group9.group09.repository.interfaces.WishlistRepository;
import com.group9.group09.repository.rowmapper.WishListRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepositoryImp implements WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();
    public WishListRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Get the wishlist items by user ID.
     *
     * @param userID The unique ID of the user whose wishlist items are to be fetched.
     * @return A List of wishList objects representing the user's wishlist items.
     * @throws WishlistNotFoundException If there was an error while fetching wishlist data from the database or if the wishlist is not found for the specified user ID.
     */
    @Override
    public List<wishList> getWishListbyUserID(Integer userID) {

        try{
            logger.info("Info Message: ");
            String getWishListbyUserIDQuery = "Select * from Wishlist where user_id=?";
            return jdbcTemplate.query(getWishListbyUserIDQuery,new WishListRowMapper(),userID);

        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new WishlistNotFoundException(e.getMessage());
        }
    }

    /**
     * Add an item to the user's wishlist.
     *
     * @param wishListRequestDTO The WishListRequestDTO object containing the details of the item to be added to the wishlist.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws WishlistNotFoundException If there was an error while adding the item to the wishlist in the database.
     */
    @Override
    public int addtoWishlist(WishListRequestDTO wishListRequestDTO) {
        try{
            logger.info("Info Message: in wishlist repository, addtoWishlist method  ");
            String addtoWishlistQuery = "Insert INTO Wishlist (city_id,place_id,activity_id,user_id) VALUES(?,?,?,?);";
            return jdbcTemplate.update(addtoWishlistQuery, wishListRequestDTO.getCityid(), wishListRequestDTO.getActivityId(),wishListRequestDTO.getPlaceId(),wishListRequestDTO.getUserid());

        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new WishlistNotFoundException(e.getMessage());
        }

    }


    /**
     * Delete a wishlist item by its unique ID.
     *
     * @param wishlistid The unique ID of the wishlist item to be deleted.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws WishlistNotFoundException If there was an error while deleting the wishlist item from the database.
     */
    @Override
    public int deletewishlistbyID(Integer wishlistid) {

        try{
            logger.info("Info Message: in wishlist repository, deleteWishlist method  ");
            String deleteWishlistQuery = "Delete from Wishlist where wishlist_id=?;";
            return jdbcTemplate.update(deleteWishlistQuery, wishlistid);

        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new WishlistNotFoundException(e.getMessage());
        }
    }
}
