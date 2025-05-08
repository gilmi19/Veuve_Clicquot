package org.example.veuve_clicquot.repository;

import org.example.veuve_clicquot.entity.ChampagneMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampagneMarkRepository extends JpaRepository<ChampagneMark, Long> {

    Optional<ChampagneMark> findByName(String name);
}
