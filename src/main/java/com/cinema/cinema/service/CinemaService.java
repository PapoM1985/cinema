package com.cinema.cinema.service;

import com.cinema.cinema.data.dto.CinemaDto;
import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.dto.SaleDto;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


public interface CinemaService {

    List<CinemaDto> getAllCinema();
    CinemaDto getCinema(String cinemaId);
    Incassi getIncassoCinema(String cinemaId);
    CinemaDto createCinema(CinemaDto cinemaNew);
}
