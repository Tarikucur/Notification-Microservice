package com.example.demo.config;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.enums.AccountType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "userTopic",
            groupId = "groupID2"
    )
    void listener(NotificationDTO data) {
        System.out.println("Welcome! You've registered with your "
                + (data.getAccountType() == AccountType.EMAIL ? "email:" : "phone number:" )
                + data.getIdentifier());
    }
}
