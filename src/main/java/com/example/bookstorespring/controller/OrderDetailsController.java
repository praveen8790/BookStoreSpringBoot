package com.example.bookstorespring.controller;

import com.example.bookstorespring.DTO.OrderDto;
import com.example.bookstorespring.entity.BookDetails;
import com.example.bookstorespring.entity.BookOrderDTO;
import com.example.bookstorespring.entity.OrderDetails;
import com.example.bookstorespring.service.IBookDetailService;
import com.example.bookstorespring.service.JwtUserDetailsService;
import com.example.bookstorespring.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderDetailsController {
    @Autowired
    private IBookDetailService bookDetailService;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping
    public OrderDetails addDetails(@RequestBody OrderDto orderDto)
    {
        List<BookOrderDTO> books=new ArrayList<>();
       orderDto.getId().forEach(id->{
           BookDetails bookDetails=bookDetailService.get(id);
           BookOrderDTO dto = new BookOrderDTO();
           dto.setId(bookDetails.getId());
           dto.setAuthor(bookDetails.getAuthor());
           dto.setDescription(bookDetails.getDescription());
           dto.setImage(bookDetails.getImage());
           dto.setPrice(bookDetails.getPrice());
           dto.setTitle(bookDetails.getTitle());
           dto.setQuantity(bookDetails.getQuantity());
           books.add(dto);
       });
        return orderDetailsService.add(
                new OrderDetails(books,orderDto.getUsername()));
    }
}
