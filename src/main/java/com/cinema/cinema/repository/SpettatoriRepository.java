package com.cinema.cinema.repository;

import com.cinema.cinema.data.dto.SpettatoriDto;
import com.cinema.cinema.data.model.Spettatori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpettatoriRepository extends JpaRepository<Spettatori,String> {

    @Query(value = "SELECT * FROM spettatori WHERE " +
            " lower(cognome) || ' ' || lower(nome) like :cognome || ' ' || :nome " ,nativeQuery = true)
    List<Spettatori> cercaSpettatore(String cognome, String nome);
}
