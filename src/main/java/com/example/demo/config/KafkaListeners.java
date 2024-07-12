package com.example.demo.config;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.enums.AccountType;
import com.example.demo.service.NotificationService;
import com.example.demo.service.notificationStrategy.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaListeners {

    @Autowired
    private NotificationService notificationService;
    private final List<NotificationStrategy> notificationStrategies;

    @Autowired
    public KafkaListeners(List<NotificationStrategy> notificationStrategies) {
        this.notificationStrategies = notificationStrategies;
    }

    @KafkaListener(
            topics = "userTopic",
            groupId = "groupID2"
    )
    void listener(NotificationDTO data) {
        for (NotificationStrategy strategy : notificationStrategies) {
            if (strategy.supports(data)) {
                strategy.sendNotification(data);
                break;
            }
        }
    }
}
