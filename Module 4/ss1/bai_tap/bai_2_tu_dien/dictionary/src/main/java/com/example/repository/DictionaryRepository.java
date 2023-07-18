package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static Map<String,String> dictionaryMap = new HashMap<>();
    static {
        dictionaryMap.put("banana","chuối");
        dictionaryMap.put("orange","cam");
        dictionaryMap.put("lemon","chanh");
        dictionaryMap.put("apple","táo");
        dictionaryMap.put("mango","xoài");
    }


    @Override
    public String translate(String englishWord) {
        String str = englishWord.trim().toLowerCase();
        return dictionaryMap.get(str);
    }
}
