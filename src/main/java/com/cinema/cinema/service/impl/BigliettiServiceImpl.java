package com.cinema.cinema.service.impl;

import com.cinema.cinema.data.dto.*;
import com.cinema.cinema.data.model.Biglietti;
import com.cinema.cinema.data.model.Sale;
import com.cinema.cinema.exception.ResourceNotFoundException;
import com.cinema.cinema.exception.UnexpectedException;
import com.cinema.cinema.repository.BigliettiRepository;
import com.cinema.cinema.service.BigliettiService;
import com.cinema.cinema.service.FilmsService;
import com.cinema.cinema.service.SaleService;
import com.cinema.cinema.service.SpettatoriService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BigliettiServiceImpl implements BigliettiService {

    private BigliettiRepository bigliettiRepo;
    private SpettatoriService spettatoriService;
    private FilmsService filmsService;
    private SaleService saleService;

    public BigliettiServiceImpl(BigliettiRepository bigliettiRepo, SpettatoriService spettatoriService, FilmsService filmsService, SaleService saleService) {
        this.bigliettiRepo = bigliettiRepo;
        this.spettatoriService = spettatoriService;
        this.filmsService = filmsService;
        this.saleService = saleService;
    }


    @Override
    public List<BigliettiDto> getAllBiglietti() {
        List<BigliettiDto> bigliettoDtoList = new ArrayList<>();
        for (Biglietti bigliettoToConvert : bigliettiRepo.findAll()) {
            bigliettoDtoList.add(bigliettoToConvert.toDto());
        }
        return bigliettoDtoList;
    }

    @Override
    public BigliettiDto getBiglietto(String bigliettoId) {
        Biglietti biglietti = bigliettiRepo.findById(bigliettoId)
                .orElseThrow(() -> new ResourceNotFoundException("Biglietti", "bigliettoId", bigliettoId));
        return biglietti.toDto();
    }


    @Override
    public BigliettiDto generaBiglietti(String spettatoreId, String filmId) {
        Double prezzo = 10.0;
        Biglietti biglietto = new Biglietti();

        SpettatoriDto spettatore = spettatoriService.getSpettatore(spettatoreId);
        FilmsDto film = filmsService.getFilm(filmId);
        SaleDto sala = saleService.getSale(film.getSala().getSalaId());

        if (spettatoriService.controlloSeMinorenne(spettatore.getSpettatoreId(), film.getFilmId())) {
            throw new UnexpectedException("Lo spettatore %s non possiede l'età minima per poter vedere il film %s", spettatore.getCognome()
                    + " " + spettatore.getNome(), film.getTitolo());
        }

        if (saleService.controllaDisponibilitaPosto(film.getSala().toModel())){

            if (spettatore.calculateAge() <= 5) {
                spettatore.setSconto(new ScontoGiovani());
            } else if (spettatore.calculateAge() >= 70) {
                spettatore.setSconto(new ScontoAdulti());
            }

            biglietto = Biglietti.builder().film(film.toModel())
                    .posto("22A")
                    .prezzo(spettatore.getSconto().getSconto(prezzo))
                    .build();

            saleService.aggiornaSala(film.getSala());
        }

        return bigliettiRepo.save(biglietto).toDto();
    }

    @Override
    public Boolean deleteById(String bigliettoId) {
        bigliettiRepo.deleteById(bigliettoId);
        return Boolean.TRUE;
    }
}
