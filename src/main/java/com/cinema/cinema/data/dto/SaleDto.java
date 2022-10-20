package com.cinema.cinema.data.dto;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.model.Sale;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto implements Dto {

    private String salaId;
    private CinemaDto cinema;
    private String nome;
    private Integer postiDisponibili;
    private Integer postiTotali;
    private Integer file;
    private Integer postiFila;

    @Override
    public Sale toModel() {
        return Sale.builder()
                .salaId(salaId)
                .cinema(cinema.toModel())
                .postiDisponibili(postiDisponibili)
                .postiTotali(postiTotali)
                .nome(nome)
                .file(file)
                .postiFila(postiFila)
                .build();
    }
}
