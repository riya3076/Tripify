package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.model.Place;
import com.group9.group09.repository.interfaces.PlaceRepository;
import com.group9.group09.repository.rowmapper.PlaceRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repository implementation for handling places.
 */
@Repository
public class PlaceRepositoryImp implements PlaceRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of PlaceRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public PlaceRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Find a place by its ID.
     *
     * @param placeID The ID of the place to find.
     * @return An Optional containing the place if found, or an empty Optional if not found.
     * @throws RuntimeException If there was an error while retrieving the place from the database.
     */
    @Override
    public Optional<Place> findByPlaceId(Integer placeID) {

        try{
            logger.info("Info Message: ");
            String findPlaceByIDQuery = "SELECT * FROM Places where place_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findPlaceByIDQuery,new PlaceRowMapper(),placeID));
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * Find a place by its name.
     *
     * @param placeName The name of the place to find.
     * @return An Optional containing the place if found, or an empty Optional if not found.
     * @throws RuntimeException If there was an error while retrieving the place from the database.
     */
    @Override
    public Optional<Place> findByPlaceName(String placeName) {

        try{
            logger.info("Info Message: ");
            String findPlaceByNameQuery = "SELECT * FROM Places where place_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findPlaceByNameQuery,new PlaceRowMapper(),placeName));
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }


    /**
     * Get the list of places associated with a specific city ID.
     *
     * @param cityID The ID of the city for which to retrieve the places.
     * @return A list of places associated with the specified city ID.
     * @throws RuntimeException If there was an error while fetching places from the database.
     */
    @Override
    public List<Place> getPlacesbyCityID(Integer cityID) {
        try{
            logger.info("Info Message: ");
            String getPlacesbyCityID = "SELECT * FROM Places where city_id=?";
            return jdbcTemplate.query(getPlacesbyCityID,new PlaceRowMapper(),cityID);
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * Get the list of places associated with a specific interest.
     *
     * @param interest The interest for which to retrieve the places.
     * @return A list of places associated with the specified interest.
     * @throws RuntimeException If there was an error while fetching places from the database.
     */
    @Override
    public List<Place> getPlacesByInterest(String interest){
        try{
            logger.info("Info Message: ");
            String getPlacesByInterest = "SELECT * FROM Places where interest like CONCAT('%', ?, '%')";
            return jdbcTemplate.query(getPlacesByInterest, new PlaceRowMapper(), interest);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Check if a place with a specific name and city ID is present in the database.
     *
     * @param placeName The name of the place to check.
     * @param cityId    The ID of the city to which the place belongs.
     * @return An Optional containing the place if found, or an empty Optional if not found.
     * @throws RuntimeException If there was an error while checking the place presence in the database.
     */
    @Override
    public Optional<Place> isPlacePresent(String placeName, Integer cityId) {
        Optional<Place> placeobj;

        try {

            logger.info("Info Message: checking if place already present");
            String findPlace = "SELECT * FROM Places where place_name = ? and city_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findPlace, new PlaceRowMapper(), placeName,cityId));

        } catch (Exception e) {

            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Add a new place to the database.
     *
     * @param placeName   The name of the place to add.
     * @param description The description of the place.
     * @param cityId      The ID of the city to which the place belongs.
     * @param interest    The interest associated with the place.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws RuntimeException If there was an error while adding the place to the database.
     */
    @Override
    public int addPlace(String placeName, String description, Integer cityId, String interest) {
        try {
            logger.info("Info Message: in addPlace method of repo ");
            String addPlaceQuery = "INSERT INTO Places (`place_name`,`description`,city_id,`interest`) VALUES (?,?,?,?);";
            return jdbcTemplate.update(addPlaceQuery, placeName, description, cityId, interest);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
