package com.cinema.cinema.service;

import com.cinema.cinema.data.dto.BigliettiDto;
import com.cinema.cinema.data.dto.SpettatoriDto;

import java.util.List;

public interface BigliettiService {

    List<BigliettiDto> getAllBiglietti();

    BigliettiDto getBiglietto(String bigliettoId);

    BigliettiDto generaBiglietti(String spettatoreId, String filmId);

    Boolean deleteById(String bigliettoId);
}
