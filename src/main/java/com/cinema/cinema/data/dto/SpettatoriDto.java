package com.cinema.cinema.data.dto;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.model.Spettatori;
import com.cinema.cinema.exception.UnexpectedException;
import com.cinema.cinema.service.ISconti;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpettatoriDto implements Dto {

    private String spettatoreId;
    private String cognome;
    private String nome;
    private LocalDate dataNascita;
    private ISconti sconto;


    public int calculateAge() {
        LocalDate currentDate = LocalDate.now();
        if ((dataNascita != null)) {
            return Period.between(dataNascita, currentDate).getYears();
        } else {
            throw new UnexpectedException("E' necessario indicare la data di nascita per lo spettatore %s",getCognome() + " " + getNome(),"");
        }
    }


    @Override
    public Spettatori toModel() {
        return Spettatori.builder()
                .spettatoreId(spettatoreId)
                .cognome(cognome)
                .nome(nome)
                .dataNascita(dataNascita)
                .build();
    }
}
