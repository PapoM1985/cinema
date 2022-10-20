package com.cinema.cinema.data.model;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.dto.BigliettiDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "biglietti")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Biglietti implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String bigliettoId;

    @Column(name = "id_film")
    private String filmId;

    private String posto;

    private Double prezzo;

    @Override
    public BigliettiDto toDto() {
        return BigliettiDto.builder()
                .bigliettoId(bigliettoId)
                .filmId(filmId)
                .posto(posto)
                .prezzo(prezzo)
                .build();
    }
}
