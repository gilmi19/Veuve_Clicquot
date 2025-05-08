package org.example.veuve_clicquot.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.veuve_clicquot.entity.ChampagneMark;
import org.example.veuve_clicquot.repository.ChampagneMarkRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChampagneMarkService {
    private final ChampagneMarkRepository champagneMarkRepository;

    public ChampagneMark findByName(String name) {
        return champagneMarkRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("сущности с именем %s не найдена".formatted(name)));
    }
}
