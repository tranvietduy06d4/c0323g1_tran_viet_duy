package com.example.service;

import com.example.model.EmailConfig;
import com.example.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public void update(EmailConfig emailConfig) {
        emailRepository.update(emailConfig);
    }

    @Override
    public EmailConfig display() {
        return emailRepository.display();
    }
}
