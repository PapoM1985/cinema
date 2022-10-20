package com.cinema.cinema.data.model;

import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.dto.FilmsDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "films")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Films implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String filmId;

    @ManyToOne(targetEntity = Sale.class)
    @JoinColumn(name = "id_sala")
    private Sale sala;

    private String titolo;

    private String genere;

    @Column(name = "id_regista")
    private String registaId;

    @Column(name = "id_produttore")
    private String produttoreId;

    @Column(name = "eta_minima")
    private Integer etaMin;

    private Integer durata;


    @Override
    public FilmsDto toDto() {
        return FilmsDto.builder()
                .filmId(filmId)
                .sala(sala.toDto())
                .titolo(titolo)
                .genere(genere)
                .registaId(registaId)
                .produttoreId(produttoreId)
                .etaMin(etaMin)
                .durata(durata)
                .build();
    }
}
