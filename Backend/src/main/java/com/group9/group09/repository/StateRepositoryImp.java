package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.StateNotFoundException;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.State;
import com.group9.group09.repository.interfaces.StateRepository;
import com.group9.group09.repository.rowmapper.StateRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository implementation for handling states related to countries.
 */

@Repository
public class StateRepositoryImp implements StateRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of StateRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public StateRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Get the state information by state ID.
     *
     * @param stateId The ID of the state to retrieve.
     * @return An Optional containing the state information if found, otherwise empty.
     * @throws StateNotFoundException If no state is found in the database with the specified state ID or there was an error while fetching the state information.
     */
    public Optional<State> findByStateId(Integer stateId) {
        try {
            logger.info("Info Message: ");
            String findStatebyIDQuery = "SELECT * FROM States where state_id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findStatebyIDQuery, new StateRowMapper(), stateId));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new StateNotFoundException("No state found in the database");
        }
    }


    /**
     * Get the state information by state name.
     *
     * @param stateName The name of the state to retrieve.
     * @return An Optional containing the state information if found, otherwise empty.
     * @throws StateNotFoundException If no state is found in the database with the specified state name or there was an error while fetching the state information.
     */
    @Override
    public Optional<State> findByStateName(String stateName) {

        try {
            logger.info("Info Message: ");
            String findStatebyNameQuery = "SELECT * FROM States where state = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findStatebyNameQuery, new StateRowMapper(), stateName));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new StateNotFoundException("No state found in the database");
        }
    }


    /**
     * Get the list of states associated with a specific country ID.
     *
     * @param countryID The ID of the country for which to retrieve the states.
     * @return A list of states associated with the specified country ID.
     * @throws StateNotFoundException If no state is found in the database with the specified country ID or there was an error while fetching the state information.
     */
    @Override
    public List<State> getStatesbyCountryID(Integer countryID) {

        try {
            logger.info("Info Message: ");
            String getStatesbyCountryIDQuery = "SELECT * FROM States where country_id = ?";
            return jdbcTemplate.query(getStatesbyCountryIDQuery, new StateRowMapper(), countryID);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new StateNotFoundException("No state found in the database");
        }
    }


    /**
     * Add a new state to the database.
     *
     * @param stateName    The name of the state to add.
     * @param description  The description of the state to add.
     * @param country_id   The ID of the country to which the state belongs.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws StateNotFoundException If there was an error while adding the state to the database.
     */
    @Override

    public int addState(String stateName, String description, int country_id) {
        try {
            logger.info("Info Message: ");
            String addStateQuery = "INSERT INTO States (`state`,`description`,country_id) VALUES (?,?,?);";
            return jdbcTemplate.update(addStateQuery, stateName, description, country_id);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new StateNotFoundException("No state found in the database");
        }
    }


    /**
     * Check if a state with the given name and country ID is already present in the database.
     *
     * @param stateName  The name of the state to check.
     * @param countryid  The ID of the country to which the state belongs.
     * @return An Optional containing the state information if found, otherwise empty.
     * @throws StateNotFoundException If no state is found in the database with the specified name and country ID or there was an error while fetching the state information.
     */
    @Override
    public Optional<State> isStatePresent(String stateName, Integer countryid) {
        Optional<State> state;
        try {

            logger.info("Info Message: checking if state already present");
            String findState = "SELECT * FROM States where state = ? and country_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findState, new StateRowMapper(), stateName, countryid));

        } catch (DataAccessException e) {

            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new StateNotFoundException("No state found in the database");
        }
    }
}