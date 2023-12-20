package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.repository.rowmapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;


/**
 * Repository implementation for handling user-related operations.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of UserRepositoryImpl with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Save user information into the database.
     *
     * @param user The User object containing the user information to save.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while saving user information to the database.
     */
    @Override
    public int saveUserInfo(User user) {

        try {
            logger.info("Info Message: ");
            Integer userId = jdbcTemplate.queryForObject("SELECT MAX(USERID) FROM User", Integer.class);
            String sql = "INSERT INTO User (name, UserID, email, password,homecountry, interest) VALUES (?, ?, ?, ?,?,?)";
            return jdbcTemplate.update(sql, user.getName(), userId+1, user.getEmail(), user.getPassword(),user.getHomeCountry(), user.getInterest());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in saving users in database");
        }
    }

    /**
     * Update the user's password in the database.
     *
     * @param user       The User object containing the updated user information.
     * @param newpassword The new password to update.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while updating the user's password in the database.
     */
    @Override
    public int updateUserPassword(User user,String newpassword) {
        try{
            String updateUserPasswordQuery = "UPDATE User SET password = ? WHERE UserID = ?";
            return jdbcTemplate.update(updateUserPasswordQuery ,newpassword,user.getUserId());
        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users password in database");
        }
    }


    /**
     * Update the user's email in the database.
     *
     * @param user The User object containing the updated user information.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while updating the user's email in the database.
     */
    @Override
    public int updateUserEmail(User user) {
        try {
            String sql = "UPDATE User SET email = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getEmail(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users email in database");
        }

    }

    /**
     * Update the user's name in the database.
     *
     * @param user The User object containing the updated user information.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while updating the user's name in the database.
     */
    @Override
    public int updateUserName(User user) {
        try {
            String sql = "UPDATE User SET name = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getName(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users name in database");
        }

    }

    /**
     * Update the user's phone number in the database.
     *
     * @param user The User object containing the updated user information.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while updating the user's phone number in the database.
     */
    @Override
    public int updateUserPhone(User user) {
        try {
            String sql = "UPDATE User SET contact_no = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getPhone(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users contact in database");
        }

    }

    /**
     * Update the user's interests in the database.
     *
     * @param user The User object containing the updated user information.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while updating the user's interests in the database.
     */
    @Override
    public int updateUserInterests(User user) {
        try {
            String sql = "UPDATE User SET interest = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getInterest(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users interests in database");
        }

    }


    /**
     * Update the user's home country in the database.
     *
     * @param user The User object containing the updated user information.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while updating the user's home country in the database.
     */
    @Override
    public int updateUserCountry(User user) {
        try {
            String sql = "UPDATE User SET homeCountry = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getHomeCountry(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users in database");
        }
    }

    /**
     * Find a user by their unique ID.
     *
     * @param userId The unique ID of the user to find.
     * @return An Optional containing the User object if found, or empty if not found.
     * @throws UserNotFoundException If there was an error while fetching user data from the database.
     */
    @Override
    public Optional<User> findByUserId(String userId) {
        try {
            logger.info("Info Message: ");
            String sql = "SELECT * FROM User where UserID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in fetching users data from database");
        }
    }

    /**
     * Find a user by their email address.
     *
     * @param email The email address of the user to find.
     * @return An Optional containing the User object if found, or empty if not found.
     * @throws UserNotFoundException If there was an error while fetching user data from the database.
     */
    @Override
    public Optional<User> findByUsermail(String email) {
        try {
            logger.info("Info Message: ");
            String sql = "SELECT * FROM User WHERE email = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), email));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in fetching users data from database");
        }
    }

    /**
     * Delete a user by their unique ID.
     *
     * @param id The unique ID of the user to delete.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws UserNotFoundException If there was an error while deleting user data from the database.
     */
    @Override
    public int deleteByUserId(String id) {
        try {
            String sql = "DELETE FROM User WHERE UserID = ?";
            return jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in deleting users data from database");
        }

    }

    /**
     * Get a user by their email address.
     *
     * @param email The email address of the user to get.
     * @return The User object representing the user with the specified email address.
     * @throws UserNotFoundException If there was an error while fetching user data from the database.
     */

    @Override
    public User getUserbyemail(String email) {
      try{
          String getUserbyIDQuery = "Select * FROM User WHERE email = ?";
          return jdbcTemplate.queryForObject(getUserbyIDQuery,new UserRowMapper() ,email);
      }catch (DataAccessException e){
          logger.error("Error Message: ");
          throw new UserNotFoundException(e.getMessage());
      }
    }
}