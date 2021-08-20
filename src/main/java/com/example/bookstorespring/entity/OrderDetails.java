package com.example.bookstorespring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderDetails {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany
    private List<BookDetails> books;
}
