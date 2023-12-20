package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.CountryNotFoundException;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.Country;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.rowmapper.CountryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



/**
 * Repository implementation for Country entities.
 */
@Repository
public class CountryRepositoryImp implements CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of CountryRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public CountryRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Find a country by its ID.
     *
     * @param countryID The ID of the country to find.
     * @return An Optional containing the country if found, or an empty Optional if not found.
     * @throws CountryNotFoundException If the country is not found in the database.
     */
    @Override
    public Optional<Country> findByCountryId(Integer countryID) {
        try {
            logger.info("Info Message: ");
            String findCountrybyIDQuery = "SELECT * FROM Countries where country_id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCountrybyIDQuery, new CountryRowMapper(), countryID));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new CountryNotFoundException(e.getMessage());
        }

    }

    /**
     * Find a country by its name.
     *
     * @param countryName The name of the country to find.
     * @return An Optional containing the country if found, or an empty Optional if not found.
     * @throws CountryNotFoundException If the country is not found in the database.
     */
    @Override
    public Optional<Country> findByCountryName(String countryName) {

        try {
            logger.info("Info Message: ");
            String findCountrybyNameQuery = "SELECT * FROM Countries where country_name = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCountrybyNameQuery, new CountryRowMapper(), countryName));
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CountryNotFoundException(e.getMessage());
        }
    }


    /**
     * Add a new country to the database.
     *
     * @param countryName The name of the country to add.
     * @param description The description of the country.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws CountryNotFoundException If there was an issue adding the country to the database.
     */
    @Override
    public int addCountry(String countryName,String description){
        try{
            logger.info("Info Message: ");
            String addCountryQuery = "INSERT INTO Countries (`country_name`,`description`) VALUES (?,?);";
            //return jdbcTemplate.update(addCountryQuery,new CountryRowMapper(),countryName,description);
            return  jdbcTemplate.update(addCountryQuery,countryName,description);
        }catch (Exception e){
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CountryNotFoundException(e.getMessage());
        }
    }

    /**
     * Get all countries from the database.
     *
     * @return A list of all countries in the database.
     * @throws CountryNotFoundException If no countries are found in the database.
     */
    @Override
    public List<Country> getCountries() {

        try {
            logger.info("Info Message: ");
            String getCountries = "SELECT * FROM Countries";
            return jdbcTemplate.query(getCountries, new CountryRowMapper());
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CountryNotFoundException(e.getMessage());
        }
    }

}
