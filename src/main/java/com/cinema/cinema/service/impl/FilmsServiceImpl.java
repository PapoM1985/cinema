package com.cinema.cinema.service.impl;

import com.cinema.cinema.data.dto.FilmsDto;
import com.cinema.cinema.data.dto.SaleDto;
import com.cinema.cinema.data.model.Films;
import com.cinema.cinema.data.model.Sale;
import com.cinema.cinema.exception.ResourceNotFoundException;
import com.cinema.cinema.repository.FilmsRepository;
import com.cinema.cinema.service.FilmsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmsServiceImpl implements FilmsService {

    private FilmsRepository filmsRepo;

    public FilmsServiceImpl(FilmsRepository filmsRepo) {
        this.filmsRepo = filmsRepo;
    }


    @Override
    public List<FilmsDto> getAllFilm() {
        List<FilmsDto> filmsDtoList = new ArrayList<>();
        for (Films filmsToConvert:filmsRepo.findAll()) {
            filmsDtoList.add(filmsToConvert.toDto());
        }
        return filmsDtoList;
    }

    @Override
    public FilmsDto getFilm(String filmId) {
        Films film = filmsRepo.findById(filmId)
                .orElseThrow(() -> new ResourceNotFoundException("Films", "filmId", filmId));
        return film.toDto();
    }

    @Override
    public FilmsDto createFilm(FilmsDto filmNew) {
        return filmsRepo.save(filmNew.toModel()).toDto();
    }
}
