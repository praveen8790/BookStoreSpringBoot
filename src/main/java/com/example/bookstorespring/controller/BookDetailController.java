package com.example.bookstorespring.controller;

import com.example.bookstorespring.DTO.UserDataDto;
import com.example.bookstorespring.config.JwtTokenUtil;

import com.example.bookstorespring.entity.BookDetails;
import com.example.bookstorespring.entity.DAOUser;
import com.example.bookstorespring.service.IBookDetailService;
import com.example.bookstorespring.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/component")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class BookDetailController {
    @Autowired
    private IBookDetailService bookDetailService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @GetMapping(value = "/book",produces = "application/json")
    public ResponseEntity<List<BookDetails>> getall(){
        return ResponseEntity.ok(bookDetailService.getAll());
    }

    @GetMapping()
    public ResponseEntity<UserDataDto> getUser(@RequestHeader(value = "Authorization") String token ){
        String jwtToken = token.substring(7);
        String userName=jwtTokenUtil.getUsernameFromToken(jwtToken);
        return ResponseEntity.ok(jwtUserDetailsService.getUserByUsername(userName));
    }

    @PatchMapping()
    public int patch(@RequestHeader(value = "Authorization") String token, @RequestBody DAOUser address){
        String jwtToken = token.substring(7);
        String userName=jwtTokenUtil.getUsernameFromToken(jwtToken);
        jwtUserDetailsService.update(userName,address);
        return 0;
    }

}
