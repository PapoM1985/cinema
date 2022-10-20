package com.cinema.cinema.repository;

import com.cinema.cinema.data.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends JpaRepository<Films,String> {
}
