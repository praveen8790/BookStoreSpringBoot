package com.example.bookstorespring.service;

import com.example.bookstorespring.entity.BookDetails;

import java.util.List;

public interface IBookDetailService {
    List<BookDetails> getAll();
}
