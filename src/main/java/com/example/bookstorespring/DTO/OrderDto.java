package com.example.bookstorespring.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderDto {
    private List<Integer> id;
    private String username;
}
