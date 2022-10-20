package com.cinema.cinema.data.model;

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

    @ManyToOne(targetEntity = Sale.class)
    @JoinColumn(name = "id_cinema")
    private Cinema cinema;

    private String nome;

    @Column(name = "posti_disponibili")
    private Integer postiDisponibili;

    @Column(name = "posti_totali")
    private Integer postiTotali;

    @Column(name = "file_disponibili")
    private Integer file;

    @Column(name = "posti_per_fila")
    private Integer postiFila;

    @Override
    public SaleDto toDto() {
        return SaleDto.builder()
                .salaId(salaId)
                .cinema(cinema.toDto())
                .postiDisponibili(postiDisponibili)
                .postiTotali(postiTotali)
                .nome(nome)
                .file(file)
                .postiFila(postiFila)
                .build();
    }
}
