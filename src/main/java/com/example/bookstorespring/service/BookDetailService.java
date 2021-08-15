package com.example.bookstorespring.service;

import com.example.bookstorespring.entity.BookDetails;
import com.example.bookstorespring.repository.BookDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDetailService implements IBookDetailService {
    @Autowired
    private BookDetailsRepository bookDetailsRepository;


    @Override
    public List<BookDetails> getAll() {
        return bookDetailsRepository.findAll();
    }
}
