package com.example.bookstorespring.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookOrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer entryID;
    private Integer id;
    private String author;
    private String title;
    private Integer price;
    private Integer quantity;
    private String image;
    private String description;
}
