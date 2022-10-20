package com.cinema.cinema.data.dto;


import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.model.Biglietti;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BigliettiDto implements Dto {

    private String bigliettoId;

    private FilmsDto film;
    private SpettatoriDto spettatore;

    private String posto;

    private Double prezzo;

    @Override
    public Biglietti toModel() {
        return Biglietti.builder()
                .bigliettoId(bigliettoId)
                .film(film.toModel())
                .posto(posto)
                .prezzo(prezzo)
                .spettatore(spettatore.toModel())
                .build();
    }
}
