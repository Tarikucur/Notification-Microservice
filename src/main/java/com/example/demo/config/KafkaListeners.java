package com.example.demo.config;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.enums.AccountType;
import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(
            topics = "userTopic",
            groupId = "groupID2"
    )
    void listener(NotificationDTO data) {
        notificationService.sendNotification(data);
    }
}
