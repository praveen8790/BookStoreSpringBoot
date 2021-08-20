package com.example.bookstorespring.repository;

import com.example.bookstorespring.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
