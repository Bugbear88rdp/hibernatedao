package com.example.hibernatedao.repository;

import com.example.hibernatedao.entity.Person;
import com.example.hibernatedao.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query(value = "SELECT * FROM persons WHERE city_of_living = :city", nativeQuery = true)
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query(value = "SELECT * FROM persons WHERE age < :age ORDER BY age ASC", nativeQuery = true)
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") Integer age);

    @Query(value = "SELECT * FROM persons WHERE name = :name AND surname = :surname", nativeQuery = true)
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}


