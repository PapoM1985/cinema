package com.cinema.cinema.service.impl;

import com.cinema.cinema.data.dto.CinemaDto;
import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.model.Cinema;
import com.cinema.cinema.data.model.Sale;
import com.cinema.cinema.exception.ResourceNotFoundException;
import com.cinema.cinema.repository.CinemaRepository;
import com.cinema.cinema.service.CinemaService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    private CinemaRepository cinemaRepo;

    public CinemaServiceImpl(CinemaRepository cinemaRepo) {
        this.cinemaRepo = cinemaRepo;
      }


    @Override
    public List<CinemaDto> getAllCinema() {
        List<CinemaDto> cinemaDtoList = new ArrayList<>();
        for (Cinema cinemaToConvert:cinemaRepo.findAll()) {
            cinemaDtoList.add(cinemaToConvert.toDto());
        }
        return cinemaDtoList;
    }

    @Override
    public CinemaDto getCinema(String cinemaId) {
        Cinema cinema = cinemaRepo.findById(cinemaId)
                .orElseThrow(() -> new ResourceNotFoundException("Cinema", "cinemaId", cinemaId));
        return cinema.toDto();
    }

    @Override
    public Incassi getIncassoCinema(String cinemaId) {
        Cinema cinema = getCinema(cinemaId).toModel();
        return cinemaRepo.incassoCinema(cinemaId);
    }

    @Override
    public CinemaDto createCinema(CinemaDto cinemaNew) {
        return cinemaRepo.save(cinemaNew.toModel()).toDto();
    }


}
