package com.cinema.cinema.data.dto;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.model.Cinema;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CinemaDto implements Dto {
    private String cinemaId;

    private String nome;
    private String indirizzo;
    private String citta;

    @Override
    public Cinema toModel() {
        return Cinema.builder()
                .cinemaId(cinemaId)
                .nome(nome)
                .indirizzo(indirizzo)
                .citta(citta)
                .build();
    }
}
