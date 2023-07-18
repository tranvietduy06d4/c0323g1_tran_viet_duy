package com.example.service;

import com.example.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService{
    @Autowired
    private IDictionaryRepository dictionaryRepository;
    @Override
    public String translate(String englishWord) {
        return dictionaryRepository.translate(englishWord);
    }
}
