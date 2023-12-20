package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.model.Notification;
import com.group9.group09.repository.interfaces.NotificationRepository;
import com.group9.group09.repository.rowmapper.NotificationRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository implementation for handling notifications.
 */
@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private static Logger logger = LoggerFactoryImpl.getLogger();
    private final JdbcTemplate jdbcTemplate;


    /**
     * Constructor to create an instance of NotificationRepositoryImpl with a JdbcTemplate.
     *
     * @param jdbcTemplate The JdbcTemplate to use for database operations.
     */
    @Autowired
    public NotificationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * Fetch notifications for a specific user.
     *
     * @param userId The ID of the user for which to fetch notifications.
     * @return A list of notifications for the specified user.
     * @throws RuntimeException If there was an error while fetching notifications from the database.
     */
    @Override
    public List<Notification> fetchNotificationsForUser(String userId) {
        try {
            logger.info("Info Message: ");
            String getNotificationsForUser = "SELECT * FROM Notification where user_id = ?";
            return jdbcTemplate.query(getNotificationsForUser, new NotificationRowMapper(), userId);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Set notifications for a specific user.
     *
     * @param notification The Notification object containing the details of the notification to set.
     * @return The number of rows affected (1 if successful, 0 otherwise). -1 if there was an error.
     */
    public int setNotificationsForUser(Notification notification) {
        try {
            logger.info("Info Message: ");
            Integer notifyId = jdbcTemplate.queryForObject("SELECT MAX(id) FROM Notification", Integer.class);
            String sql = "Insert into Notification (id, category, description, user_id) " +
                    "VALUES (?,?,?,?)";
            return jdbcTemplate.update(sql, notifyId + 1, notification.getCategory(),
                    notification.getDescription(), notification.getUserId());
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
