package com.example.demo.service;

import com.example.demo.dto.NotificationDTO;
import com.example.demo.enums.AccountType;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(NotificationDTO data) {
        System.out.println("Welcome! You've registered with your "
                + (data.getAccountType() == AccountType.EMAIL ? "email:" : "phone number:" )
                + data.getIdentifier());
    }
}