package com.group9.group09.repository;

import com.group9.group09.exception.CityNotFoundException;
import com.group9.group09.model.City;
import com.group9.group09.repository.interfaces.CityRepository;
import com.group9.group09.repository.rowmapper.CityRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repository implementation for City entities.
 */
@Repository
public class CityRepositoryImp implements CityRepository {

    private final JdbcTemplate jdbcTemplate;


    /**
     * Constructor to create an instance of CityRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    @Autowired
    public CityRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Logger logger = LoggerFactory.getLogger(CityRepositoryImp.class);


    /**
     * Find a city by its ID.
     *
     * @param cityId The ID of the city to find.
     * @return An Optional containing the city if found, or an empty Optional if not found.
     * @throws CityNotFoundException If the city is not found in the database.
     */
    public Optional<City> findByCityId(Integer cityId) {
        try {
            logger.info("Info Message: ");
            String findCitybyIDQuery = "SELECT * FROM Cities where City_ID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCitybyIDQuery, new CityRowMapper(), cityId));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new CityNotFoundException(e.getMessage());
        }
    }


    /**
     * Find a city by its name.
     *
     * @param cityName The name of the city to find.
     * @return An Optional containing the city if found, or an empty Optional if not found.
     * @throws CityNotFoundException If the city is not found in the database.
     */
    @Override
    public Optional<City> findByCityName(String cityName) {

        try {
            logger.info("Info Message: ");
            String findCitybyNameQuery = "SELECT * FROM Cities where city = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCitybyNameQuery, new CityRowMapper(), cityName));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new CityNotFoundException(e.getMessage());
        }
    }

    /**
     * Get all cities in a state based on its ID.
     *
     * @param stateID The ID of the state to retrieve cities for.
     * @return A list of cities in the specified state.
     * @throws CityNotFoundException If no cities are found in the database for the given state ID.
     */
    @Override
    public List<City> getCitiesbyStateID(Integer stateID) {

        try {
            logger.info("Info Message: ");
            String getCitiesbyStateIDQuery = "SELECT * FROM Cities where state_id = ?";
            return jdbcTemplate.query(getCitiesbyStateIDQuery, new CityRowMapper(), stateID);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new CityNotFoundException(e.getMessage());
        }

    }

    /**
     * Check if a city with the given name and state ID already exists in the database.
     *
     * @param city    The name of the city to check.
     * @param stateID The ID of the state associated with the city.
     * @return An Optional containing the city if it exists, or an empty Optional if not found.
     * @throws CityNotFoundException If no city is found in the database with the given name and state ID.
     */
    @Override
    public Optional<City> isCityPresent(String city, Integer stateID) {

        Optional<City> cityobj;
        try {

            logger.info("Info Message: checking if city already present");
            String findCity = "SELECT * FROM Cities where city = ? and state_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCity, new CityRowMapper(), city, stateID));

        } catch (DataAccessException e) {

            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CityNotFoundException(e.getMessage());
        }
    }


    /**
     * Add a new city to the database.
     *
     * @param city       The name of the city to add.
     * @param description The description of the city.
     * @param stateID    The ID of the state associated with the city.
     * @param weather    The weather information of the city.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws CityNotFoundException If there was an issue adding the city to the database.
     */
    @Override
    public int addCity(String city, String description, Integer stateID, String weather) {
        try {
            logger.info("Info Message: in addCity method of repo ");
            String addCityQuery = "INSERT INTO Cities (`city`,`description`,state_id,`weather`) VALUES (?,?,?,?);";
            return jdbcTemplate.update(addCityQuery, city, description, stateID, weather);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CityNotFoundException(e.getMessage());
        }
    }
}
