package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.ItemNotFoundException;
import com.group9.group09.model.ItemstoCarry;
import com.group9.group09.repository.interfaces.ItemsRepository;
import com.group9.group09.repository.rowmapper.ActivityRowMapper;
import com.group9.group09.repository.rowmapper.ItemstoCarryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemsRepositoryImp implements ItemsRepository{

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of ItemsRepositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public ItemsRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Get all items to carry from the database.
     *
     * @return A list of all items to carry in the database.
     * @throws ItemNotFoundException If no items to carry are found in the database.
     */
    @Override
    public List<ItemstoCarry> getAllItems() {

        try {
            logger.info("Info Message: ");
            String getAllItemstoCarryQuery = "SELECT * FROM Itemstocarry";
            return jdbcTemplate.query(getAllItemstoCarryQuery, new ItemstoCarryRowMapper(), null);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new ItemNotFoundException(e.getMessage());
        }
    }
}