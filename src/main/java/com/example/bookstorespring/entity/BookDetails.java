package com.example.bookstorespring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookDetails {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String author;
    private String title;
    private Integer price;
    private Integer quantity;
    private String image;
    private String description;
}
