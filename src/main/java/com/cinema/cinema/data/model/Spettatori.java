package com.cinema.cinema.data.model;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.dto.SpettatoriDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "spettatori")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Spettatori implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String spettatoreId;

    @Column(name = "id_biglietto")
    private String bigliettoId;

    private String cognome;
    private String nome;

    @Column(name = "data_di_nascita")
    private Timestamp dataNascita;

    @Override
    public SpettatoriDto toDto() {
        return SpettatoriDto.builder()
                .spettatoreId(spettatoreId)
                .bigliettoId(bigliettoId)
                .cognome(cognome)
                .nome(nome)
                .dataNascita(dataNascita)
                .build();
    }
}
