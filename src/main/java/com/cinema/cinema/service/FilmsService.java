package com.cinema.cinema.service;

import com.cinema.cinema.data.dto.FilmsDto;
import com.cinema.cinema.data.dto.SaleDto;

import java.util.List;

public interface FilmsService {

    List<FilmsDto> getAllFilm();
    FilmsDto getFilm(String filmId);
    FilmsDto createFilm(FilmsDto filmNew);
}
