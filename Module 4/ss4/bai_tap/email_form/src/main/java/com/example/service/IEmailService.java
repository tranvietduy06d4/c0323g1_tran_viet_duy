package com.example.service;

import com.example.model.EmailConfig;

public interface IEmailService {
    public void update(EmailConfig emailConfig);
    EmailConfig display();
}
