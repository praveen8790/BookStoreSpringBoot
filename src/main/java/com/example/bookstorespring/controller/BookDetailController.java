package com.example.bookstorespring.controller;

import com.example.bookstorespring.entity.BookDetails;
import com.example.bookstorespring.service.IBookDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.GET,
        RequestMethod.OPTIONS,RequestMethod.HEAD,RequestMethod.POST},origins = "*")
@RestController
@RequestMapping("/component/book")
public class BookDetailController {
    @Autowired
    private IBookDetailService bookDetailService;
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BookDetails>> getall(){
        return new ResponseEntity<>(bookDetailService.getAll(), HttpStatus.ACCEPTED);
    }

}
