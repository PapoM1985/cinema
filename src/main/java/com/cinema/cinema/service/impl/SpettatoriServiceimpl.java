package com.cinema.cinema.service.impl;

import com.cinema.cinema.data.dto.FilmsDto;
import com.cinema.cinema.data.dto.SpettatoriDto;
import com.cinema.cinema.data.model.Spettatori;
import com.cinema.cinema.exception.ResourceNotFoundException;
import com.cinema.cinema.repository.SpettatoriRepository;
import com.cinema.cinema.service.FilmsService;
import com.cinema.cinema.service.SpettatoriService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpettatoriServiceimpl implements SpettatoriService {

    private SpettatoriRepository spettatoriRepo;
    private FilmsService filmsService;

    public SpettatoriServiceimpl(SpettatoriRepository spettatoriRepo, FilmsService filmsService) {
        this.spettatoriRepo = spettatoriRepo;
        this.filmsService = filmsService;
    }

    @Override
    public List<SpettatoriDto> getAllSpettatori() {
        List<SpettatoriDto> spettatoriDtoList = new ArrayList<>();
        for (Spettatori spettatoriToConvert:spettatoriRepo.findAll()) {
            spettatoriDtoList.add(spettatoriToConvert.toDto());
        }
        return spettatoriDtoList;
    }

    @Override
    public SpettatoriDto getSpettatore(String spettatoreId) {
        Spettatori spettatore = spettatoriRepo.findById(spettatoreId)
                .orElseThrow(() -> new ResourceNotFoundException("Spettatori", "spettatoreId", spettatoreId));
        return spettatore.toDto();
    }

    @Override
    public SpettatoriDto nuovoSpettatore(SpettatoriDto spettatoreNew) {
        return spettatoriRepo.save(spettatoreNew.toModel()).toDto();
    }

    @Override
    public List<Spettatori> cercaSpettatore(String cognome, String nome) {
        return spettatoriRepo.cercaSpettatore(cognome,nome);
    }

    @Override
    public Boolean controlloSeMinorenne(String spettatoreId, String filmId) {
        SpettatoriDto spettatore = getSpettatore(spettatoreId);
        FilmsDto film = filmsService.getFilm(filmId);
        if (spettatore.calculateAge()<= film.getEtaMin()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String getEta(String spettatoreId) {
        SpettatoriDto spettatore = getSpettatore(spettatoreId);

        return "Lo spettatore " + spettatore.getCognome() + " " + spettatore.getNome() + "ha " + spettatore.calculateAge() + "anni";
    }
}
