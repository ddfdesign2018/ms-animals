package com.ddfdesign.msanimals.repository;

import com.ddfdesign.msanimals.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalsRepository extends JpaRepository<Animal, Long > {
}
