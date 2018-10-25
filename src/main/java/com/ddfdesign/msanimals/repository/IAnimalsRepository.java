package com.ddfdesign.msanimals.repository;

import com.ddfdesign.msanimals.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnimalsRepository extends JpaRepository<Animal, Long > {
    List<Animal> findByName(String name);
    List<Animal> findByBreed(Long breed);
    List<Animal> findByStatus(String Status);
    List<Animal> findByClient(Long client);
    @Query("SELECT p FROM Animal p WHERE p.father = :father AND p.mother = :mother")
    List<Animal> findFatherMother(@Param("father") Long father, @Param("mother") Long mother);
}
