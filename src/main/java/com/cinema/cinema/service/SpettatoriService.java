package com.cinema.cinema.service;

import com.cinema.cinema.data.dto.SpettatoriDto;
import com.cinema.cinema.data.model.Spettatori;

import java.util.List;

public interface SpettatoriService {

    List<SpettatoriDto> getAllSpettatori();
    SpettatoriDto getSpettatore(String salaId);
    SpettatoriDto nuovoSpettatore(SpettatoriDto salaNew);
    List<Spettatori> cercaSpettatore(String cognome, String nome);
    Boolean controlloSeMinorenne(String spettatoreId, String filmId);
    String getEta(String spettatoreId);
}
