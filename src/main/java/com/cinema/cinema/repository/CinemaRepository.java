package com.cinema.cinema.repository;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,String> {

    @Query(value = "SELECT c.nome,sum(b.prezzo) FROM cinema c " +
            " INNER JOIN sale s ON s.id_cinema = c.id " +
            " INNER JOIN films f ON l.id_sala = s.id " +
            " INNER JOIN biglietti b ON b.id_film = f.id " +
            " WHERE c.id = :cinemaId " +
            " GROUP BY c.nome",nativeQuery = true)
    Incassi incassoCinema(String cinemaId);
}
