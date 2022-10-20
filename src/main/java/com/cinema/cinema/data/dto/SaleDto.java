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
    private String cinemaId;
    private String postiDisponibili;
    private String postiTotali;

    @Override
    public Sale toModel() {
        return Sale.builder()
                .salaId(salaId)
                .cinemaId(cinemaId)
                .postiDisponibili(postiDisponibili)
                .postiTotali(postiTotali)
                .build();
    }
}
