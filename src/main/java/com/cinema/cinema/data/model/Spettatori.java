package com.cinema.cinema.data.model;

import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.dto.SpettatoriDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

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

    private String cognome;
    private String nome;

    @Column(name = "data_di_nascita")
    private LocalDate dataNascita;

    @Override
    public SpettatoriDto toDto() {
        return SpettatoriDto.builder()
                .spettatoreId(spettatoreId)
                .cognome(cognome)
                .nome(nome)
                .dataNascita(dataNascita)
                .build();
    }
}
