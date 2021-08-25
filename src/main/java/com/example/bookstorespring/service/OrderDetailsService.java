package com.example.bookstorespring.service;

import com.example.bookstorespring.entity.OrderDetails;
import com.example.bookstorespring.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


    public OrderDetails add(OrderDetails orderDetails){
        return orderDetailsRepository.save(orderDetails);
    }
}
