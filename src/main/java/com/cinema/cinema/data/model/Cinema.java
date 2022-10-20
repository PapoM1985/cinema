package com.cinema.cinema.data.model;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.dto.CinemaDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "cinema")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cinema implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String cinemaId;

    private String nome;
    private String indirizzo;
    private String citta;

    @Override
    public CinemaDto toDto() {
        return CinemaDto.builder()
                .cinemaId(cinemaId)
                .nome(nome)
                .indirizzo(indirizzo)
                .citta(citta)
                .build();
    }
}
