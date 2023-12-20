package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.RequestDTO.NotificationRequestDTO;
import com.group9.group09.DTO.ResponseDTO.NotificationResponseDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationResponseDTO> fetchNotificationsForUser(NotificationRequestDTO requestDTO);
}
