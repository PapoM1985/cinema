package com.cinema.cinema.data.dto;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.model.Spettatori;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpettatoriDto implements Dto {

    private String spettatoreId;
    private String bigliettoId;
    private String cognome;
    private String nome;
    private Timestamp dataNascita;

    @Override
    public Spettatori toModel() {
        return Spettatori.builder()
                .spettatoreId(spettatoreId)
                .bigliettoId(bigliettoId)
                .cognome(cognome)
                .nome(nome)
                .dataNascita(dataNascita)
                .build();
    }
}
