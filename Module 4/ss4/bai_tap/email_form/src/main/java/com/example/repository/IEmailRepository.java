package com.example.repository;

import com.example.model.EmailConfig;

public interface IEmailRepository {
    void update(EmailConfig emailConfig);

    EmailConfig display();
}
