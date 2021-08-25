package com.example.bookstorespring.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionType;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<BookOrderDTO> books;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="username",referencedColumnName = "username")
    private String username;


    public OrderDetails(List<BookOrderDTO> books,String username) {
        this.books = books;
        this.username=username;
    }
}
