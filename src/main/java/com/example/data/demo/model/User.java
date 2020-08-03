package com.example.data.demo.model;

import lombok.Data;
import org.hibernate.annotations.Sort;
import org.springframework.data.web.SortDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users", schema = "store")
@Data
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store.users_id_seq")
    @SequenceGenerator(name = "store.users_id_seq", sequenceName = "store.users_id_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column(name = "created_at")
    private LocalDate creationDate;
}
