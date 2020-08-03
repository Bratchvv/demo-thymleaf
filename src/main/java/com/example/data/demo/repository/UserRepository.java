package com.example.data.demo.repository;

import com.example.data.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();

    User findByEmail(String email);

    @Query("select u from User u where u.creationDate between :startDate and :endDate")
    Stream<User> findUsersByPeriod(@Param("startDate")LocalDate a1, @Param("endDate")LocalDate a2);
}
