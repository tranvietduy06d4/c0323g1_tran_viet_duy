package com.example.service;

import com.example.model.Book;
import com.example.model.Code;
import com.example.repository.ICodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService implements ICodeService{
    @Autowired
    private ICodeRepository codeRepository;
    @Override
    public void add(int rentCode, Book book) {
        Code code = new Code(rentCode,book);
        codeRepository.save(code);
    }

    @Override
    public void deleteByCode(Code code) {
        codeRepository.delete(code);
    }

    @Override
    public Code findCodeByRentCode(int rentCode) {
        return codeRepository.findCodeByRentCode(rentCode);
    }

}
