package com.group9.group09.service;

import com.group9.group09.DTO.RequestDTO.NotificationRequestDTO;
import com.group9.group09.DTO.ResponseDTO.NotificationResponseDTO;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.Notification;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.NotificationRepository;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public List<NotificationResponseDTO> fetchNotificationsForUser(NotificationRequestDTO requestDTO) {

        try {
            String token = requestDTO.getToken().replace("Bearer ", "");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            List<Notification> notifications = notificationRepository.fetchNotificationsForUser(user.get().getUserId());
            List<NotificationResponseDTO> notificationResponseDTOList = new ArrayList<>();
            for (Notification notification: notifications){
                NotificationResponseDTO notificationResponseDTO = new NotificationResponseDTO();
                notificationResponseDTO.setCategory(notification.getCategory());
                notificationResponseDTO.setDescription(notification.getDescription());
                notificationResponseDTO.setId(notification.getId());
                notificationResponseDTOList.add(notificationResponseDTO);
            }
            return notificationResponseDTOList;
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
