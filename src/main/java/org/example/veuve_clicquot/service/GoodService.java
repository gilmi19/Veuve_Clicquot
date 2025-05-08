package org.example.veuve_clicquot.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.veuve_clicquot.entity.Good;
import org.example.veuve_clicquot.repository.GoodRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodService {
    private final GoodRepository goodRepository;

    public Good findByChampagneMark_Id(String name) {
        return goodRepository.findFirstByChampagneMark_Name(name)
                .orElseThrow(() -> new EntityNotFoundException("товар с именем %s не найден".formatted(name)));
    }

    public void writeOffGoods(Good good, Integer goodsForBuy) {
        good.setCountGoods(good.getCountGoods() - goodsForBuy);
    }
}
