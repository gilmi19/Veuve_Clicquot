package org.example.veuve_clicquot.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.example.veuve_clicquot.dto.BuyGoodsDto;
import org.example.veuve_clicquot.service.GoodService;
import org.example.veuve_clicquot.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/good")
public class GoodController {
//3. Дать возможность покупать товар (http endpoint):
//3.1. На вход имя товара, количество бутылок для покупки.
//3.2. При вызове метода покупки, сначала проверяется наличие этого товара и количества.
// Если товара нет, клиент должен увидеть текст: товара нет в наличии. Если товар есть, то он списывается.
    private final OrderService orderService;

    @PostMapping("/buy")
    public ResponseEntity<?> buyGoods(@RequestBody BuyGoodsDto dto) {
        orderService.buyGoods(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
