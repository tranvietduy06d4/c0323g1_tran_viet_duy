package com.example.repository;

import com.example.model.EmailConfig;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository{
    private static EmailConfig email = new EmailConfig();
    static {
        email.setLanguage("Vietnamese");
        email.setFilter(true);
        email.setPageSize(5);
        email.setSignature("Hoa");
    }



    @Override
    public void update(EmailConfig emailConfig) {
        email=emailConfig;
    }

    @Override
    public EmailConfig display() {
        return email;
    }
}
