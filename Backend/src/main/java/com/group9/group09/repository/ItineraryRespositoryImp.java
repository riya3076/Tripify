package com.group9.group09.repository;

import com.group9.group09.DTO.RequestDTO.ItineraryRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ItineraryResponseDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.model.ItemstoCarry;
import com.group9.group09.model.Itinerary;
import com.group9.group09.repository.interfaces.ItineraryRepository;
import com.group9.group09.repository.rowmapper.ItemstoCarryRowMapper;
import com.group9.group09.repository.rowmapper.ItineraryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItineraryRespositoryImp implements ItineraryRepository {
    private JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();

    /**
     * Constructor to create an instance of ItineraryRespositoryImp with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    public ItineraryRespositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Get the list of itineraries associated with a specific user ID.
     *
     * @param userid The ID of the user for which to retrieve the itineraries.
     * @return A list of itineraries associated with the specified user ID.
     * @throws RuntimeException If there was an error while retrieving the itineraries from the database.
     */
    @Override
    public List<Itinerary> getItineraryList(Integer userid) {

        try {
            logger.info("Info Message: ");
            String getItinerarybyUserIDQuery = "SELECT * FROM Itinerary where user_id=?";
            return jdbcTemplate.query(getItinerarybyUserIDQuery, new ItineraryRowMapper(), userid);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * Add an itinerary to the database.
     *
     * @param itineraryRequestDTO The ItineraryRequestDTO object containing the details of the itinerary to add.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws RuntimeException If there was an error while adding the itinerary to the database.
     */

    @Override
    public int addtoItinerary(ItineraryRequestDTO itineraryRequestDTO) {
        try{
            logger.info("Info Message: in itinerary repository, addtoitinerary method  ");
            String addtoItineraryQuery = "Insert INTO Itinerary  (user_id,`start_date`,`end_date`,`placeid`,`activityid`,`title`) VALUES(?,?,?,?,?,?);";
            return jdbcTemplate.update(addtoItineraryQuery, itineraryRequestDTO.getUserid(), itineraryRequestDTO.getStartdate(),itineraryRequestDTO.getEnddate(),itineraryRequestDTO.getPlaceid(),itineraryRequestDTO.getActivityid(),itineraryRequestDTO.getTitle());
        }catch (Exception e){
            logger.error("Error Message: error adding to itinerary list ");
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Delete an itinerary from the database by its ID.
     *
     * @param itineraryid The ID of the itinerary to delete.
     * @return The number of rows affected (1 if successful, 0 otherwise).
     * @throws RuntimeException If there was an error while deleting the itinerary from the database.
     */
    @Override
    public int deleteitinerarybyid(Integer itineraryid) {


        try{
            logger.info("Info Message: in itinerary repository, deleteitinerarybyid method  ");
            String deleteItineraryByIDQuery = "Delete from Itinerary where itinerary_id=?;";
            return jdbcTemplate.update(deleteItineraryByIDQuery, itineraryid);

        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }
}