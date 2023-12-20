package com.group9.group09.repository.interfaces;

import com.group9.group09.model.Notification;

import java.util.List;

public interface NotificationRepository {

    List<Notification> fetchNotificationsForUser(String userId);
    int setNotificationsForUser(Notification notification);
}
