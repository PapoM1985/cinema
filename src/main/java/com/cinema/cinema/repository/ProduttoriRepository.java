package com.cinema.cinema.repository;

import com.cinema.cinema.data.model.Produttori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduttoriRepository extends JpaRepository<Produttori,String> {
}
