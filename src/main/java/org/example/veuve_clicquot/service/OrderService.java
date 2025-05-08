package org.example.veuve_clicquot.service;

import lombok.RequiredArgsConstructor;
import org.example.veuve_clicquot.dto.BuyGoodsDto;
import org.example.veuve_clicquot.entity.ChampagneMark;
import org.example.veuve_clicquot.entity.Good;
import org.example.veuve_clicquot.exception.GoodCountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final GoodService goodService;
    private final ChampagneMarkService champagneMarkService;

    //3. Дать возможность покупать товар (http endpoint):
    //3.1. На вход имя товара, количество бутылок для покупки.
    //3.2. При вызове метода покупки, сначала проверяется наличие этого товара и количества.
    // Если товара нет, клиент должен увидеть текст: товара нет в наличии. Если товар есть, то он списывается.
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public void buyGoods(BuyGoodsDto dto) {
        ChampagneMark champagneMark = champagneMarkService.findByName(dto.name());
        Good good = goodService.findByChampagneMark_Id(dto.name());
        if (good.getCountGoods() == 0) {
            throw new GoodCountException("Товаров на складе нет");
        } else if (good.getCountGoods() < dto.countGoods()) {
            throw new GoodCountException("Товара в таком количестве не хватает на складе");
        } else {
            goodService.writeOffGoods(good, dto.countGoods());
        }
    }
}

