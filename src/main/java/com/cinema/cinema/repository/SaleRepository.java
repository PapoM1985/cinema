package com.cinema.cinema.repository;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface SaleRepository extends JpaRepository<Sale,String> {

    @Query(value = "SELECT * FROM sale WHERE id = :salaId",nativeQuery = true)
    Sale isCompletedSale(String salaId);

    @Query(value = "SELECT s.nome, sum(b.prezzo) FROM sale s " +
            " INNER JOIN films f ON s.id = f.id_sala " +
            " INNER JOIN biglietti b ON b.id_film = f.id " +
            " WHERE s.id = :salaId " +
            " GROUP BY s.nome",nativeQuery = true)
    Incassi incassoSala(String salaId);


}
