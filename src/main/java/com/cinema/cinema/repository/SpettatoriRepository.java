package com.cinema.cinema.repository;

import com.cinema.cinema.data.model.Spettatori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpettatoriRepository extends JpaRepository<Spettatori,String> {

}
