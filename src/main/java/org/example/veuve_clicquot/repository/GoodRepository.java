package org.example.veuve_clicquot.repository;

import org.example.veuve_clicquot.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GoodRepository extends JpaRepository<Good, Long> {

    Optional<Good> findFirstByChampagneMark_Name(String name);
}
