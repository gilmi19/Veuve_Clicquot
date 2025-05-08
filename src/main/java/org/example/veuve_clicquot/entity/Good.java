package org.example.veuve_clicquot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Good {

    @Id
    private Long id;

    @JoinColumn(name = "mark_id")
    @OneToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    ChampagneMark champagneMark;

    @Column
    @Min(value = 0)
    private Integer countGoods;

    @Column
    @DecimalMin(value = "0.1")
    private BigDecimal price;

    public Good(ChampagneMark champagneMark, Integer countGoods, BigDecimal price) {
        this.champagneMark = champagneMark;
        this.countGoods = countGoods;
        this.price = price;
    }
}
