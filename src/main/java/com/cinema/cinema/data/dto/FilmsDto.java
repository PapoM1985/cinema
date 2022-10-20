package com.cinema.cinema.data.dto;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.model.Films;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilmsDto implements Dto {

    private String filmId;

    private SaleDto sala;

    private String titolo;

    private String genere;

    private String registaId;

    private String produttoreId;

    private Integer etaMin;

    private Integer durata;

    @Override
    public Films toModel() {
        return Films.builder()
                .filmId(filmId)
                .sala(sala.toModel())
                .titolo(titolo)
                .genere(genere)
                .registaId(registaId)
                .produttoreId(produttoreId)
                .etaMin(etaMin)
                .durata(durata)
                .build();
    }
}
