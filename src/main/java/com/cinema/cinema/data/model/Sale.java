package com.cinema.cinema.data.model;

import com.cinema.cinema.data.archetype.Dto;
import com.cinema.cinema.data.archetype.Model;
import com.cinema.cinema.data.dto.SaleDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "sale")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Model {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String salaId;

    @Column(name = "id_cinema")
    private String cinemaId;

    @Column(name = "posti_disponibili")
    private String postiDisponibili;

    @Column(name = "posti_totali")
    private String postiTotali;

    @Override
    public SaleDto toDto() {
        return SaleDto.builder()
                .salaId(salaId)
                .cinemaId(cinemaId)
                .postiDisponibili(postiDisponibili)
                .postiTotali(postiTotali)
                .build();
    }
}
