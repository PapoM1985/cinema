package com.cinema.cinema.repository;

import com.cinema.cinema.data.model.Registi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistiRepository extends JpaRepository<Registi,String> {
}
