package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.ActivityNotFoundException;
import com.group9.group09.model.Activity;
import com.group9.group09.model.Place;
import com.group9.group09.repository.interfaces.ActivityRepository;
import com.group9.group09.repository.rowmapper.ActivityRowMapper;
import com.group9.group09.repository.rowmapper.PlaceRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository implementation for Activity entities.
 */
@Repository
public class ActivityRepositoryImp implements ActivityRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of ActivityRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public ActivityRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Find activity by its ID.
     *
     * @param activityID The ID of the activity to find.
     * @return An Optional containing the activity if found, or an empty Optional if not found.
     * @throws ActivityNotFoundException If the activity is not found in the database.
     */
    @Override
    public Optional<Activity> findByActivityId(Integer activityID) {

        try {
            logger.info("Info Message: ");
            String findActivitybyIDQuery = "SELECT * FROM Activity where activity_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findActivitybyIDQuery, new ActivityRowMapper(), activityID));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new ActivityNotFoundException(e.getMessage());
        }
    }

    /**
     * Find activity by its name.
     *
     * @param activityName The name of the activity to find.
     * @return An Optional containing the activity if found, or an empty Optional if not found.
     * @throws ActivityNotFoundException If the activity is not found in the database.
     */
    @Override
    public Optional<Activity> findByActivityName(String activityName) {

        try {
            logger.info("Info Message: ");
            String findActivitybyNameQuery = "SELECT * FROM Activity where activit_name = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findActivitybyNameQuery, new ActivityRowMapper(), activityName));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new ActivityNotFoundException(e.getMessage());
        }

    }

    /**
     * Get all activities in a city based on its ID.
     *
     * @param cityID The ID of the city to retrieve activities for.
     * @return A list of activities in the specified city.
     * @throws ActivityNotFoundException If no activities are found in the database for the given city ID.
     */
    @Override
    public List<Activity> getActivitiesbyCityID(Integer cityID) {

        try {
            logger.info("Info Message: ");
            String getActivitiesByCityID = "SELECT * FROM Activity where city_id = ?";
            return jdbcTemplate.query(getActivitiesByCityID, new ActivityRowMapper(), cityID);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new ActivityNotFoundException(e.getMessage());
        }
    }

    /**
     * Get all activities from the database.
     *
     * @return A list of all activities in the database.
     * @throws ActivityNotFoundException If no activities are found in the database.
     */

    @Override
    public List<Activity> getAllActivities() {

        try {
            logger.info("Info Message: ");
            String getAllActivitiesQuery = "SELECT * FROM Activity";
            return jdbcTemplate.query(getAllActivitiesQuery, new ActivityRowMapper(), null);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new ActivityNotFoundException(e.getMessage());
        }
    }


    /**
     * Get activities that match the given interest keyword.
     *
     * @param interest The keyword to search for in activity interests.
     * @return A list of activities matching the interest keyword.
     * @throws ActivityNotFoundException If no activities are found in the database with the given interest.
     */
    @Override
    public List<Activity> getActivitiesByInterest(String interest){
        try{
            logger.info("Info Message: ");
            String getActivityByInterest = "SELECT * FROM Activity where interest like CONCAT('%', ?, '%')";
            return jdbcTemplate.query(getActivityByInterest, new ActivityRowMapper(), interest);
        }
        catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new ActivityNotFoundException(e.getMessage());
        }
    }

    /**
     * Check if an activity with the given name and city ID already exists in the database.
     *
     * @param activityName The name of the activity to check.
     * @param cityId       The ID of the city associated with the activity.
     * @return An Optional containing the activity if it exists, or an empty Optional if not found.
     * @throws ActivityNotFoundException If no activity is found in the database with the given name and city ID.
     */
    @Override
    public Optional<Activity> isActivityPresent(String activityName, Integer cityId) {
    Optional<Activity> activityobj;

    try {

        logger.info("Info Message: checking if activity already present");
        String findActivity = "SELECT * FROM Activity where activity_name = ? and city_id=?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(findActivity, new ActivityRowMapper(), activityName,cityId));

    } catch (DataAccessException e) {

        logger.error("Error Message: ");
        System.out.println(e.getMessage());
        throw new ActivityNotFoundException(e.getMessage());
    }

    }



    /**
     * Add a new activity to the database.
     *
     * @param activityName The name of the activity to add.
     * @param description  The description of the activity.
     * @param cityId       The ID of the city associated with the activity.
     * @param interest     The interest keyword associated with the activity.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws ActivityNotFoundException If there was an issue adding the activity to the database.
     */
    @Override
    public int addPlace(String activityName, String description, Integer cityId, String interest) {

    try{
        logger.info("Info Message: in addactivity method of repo ");
        String addActivityQuery = "INSERT INTO Activity (`activity_name`,`description`,city_id,`interest`) VALUES (?,?,?,?);";
        return  jdbcTemplate.update(addActivityQuery,activityName,description,cityId,interest);
    }catch (DataAccessException e){
        logger.error("Error Message: ");
        System.out.println(e.getMessage());
        throw new ActivityNotFoundException(e.getMessage());
    }

    }
}