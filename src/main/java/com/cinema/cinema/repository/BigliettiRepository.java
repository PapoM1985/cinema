package com.cinema.cinema.repository;

import com.cinema.cinema.data.model.Biglietti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BigliettiRepository extends JpaRepository<Biglietti, String> {
}
