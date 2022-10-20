package com.cinema.cinema.data.model;

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

    @ManyToOne(targetEntity = Films.class)
    @JoinColumn(name = "id_film")
    private Films film;

    @ManyToOne(targetEntity = Spettatori.class)
    @JoinColumn(name = "id_spettatore")
    private Spettatori spettatore;

    private String posto;

    private Double prezzo;

    @Override
    public BigliettiDto toDto() {
        return BigliettiDto.builder()
                .bigliettoId(bigliettoId)
                .film(film.toDto())
                .posto(posto)
                .spettatore(spettatore.toDto())
                .prezzo(prezzo)
                .build();
    }
}
