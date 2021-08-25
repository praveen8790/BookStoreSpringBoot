package com.example.bookstorespring.repository;

import com.example.bookstorespring.entity.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailsRepository extends JpaRepository<BookDetails,Integer>{
    BookDetails findBookDetailsById(Integer id);
}
