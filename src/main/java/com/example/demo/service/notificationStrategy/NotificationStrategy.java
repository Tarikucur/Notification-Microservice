package com.example.demo.service.notificationStrategy;

import com.example.demo.dto.NotificationDTO;

public interface NotificationStrategy {
    boolean supports(NotificationDTO data);
    void sendNotification(NotificationDTO data);
}