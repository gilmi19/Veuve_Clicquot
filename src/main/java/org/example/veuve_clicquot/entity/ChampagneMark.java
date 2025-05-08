package org.example.veuve_clicquot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "champagne_mark")
public class ChampagneMark {
    @Id
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String type;

    @OneToOne(mappedBy = "champagneMark")
    private Good good;

    public ChampagneMark(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
