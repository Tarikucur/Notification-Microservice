package com.example.demo.service.notificationStrategy;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.enums.AccountType;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationStrategy implements NotificationStrategy {

    @Override
    public boolean supports(NotificationDTO data) {
        return data.getAccountType() == AccountType.PHONE_NUMBER;
    }

    @Override
    public void sendNotification(NotificationDTO data) {
        System.out.println("Welcome! You've registered with your phone number: " + data.getIdentifier());
    }
}
