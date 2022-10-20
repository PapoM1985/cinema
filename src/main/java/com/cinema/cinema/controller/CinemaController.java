package com.cinema.cinema.controller;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    private CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/incasso/cinema/{cinemaId}")
    public ResponseEntity<Incassi> getincassoSala(@PathVariable String cinemaId){
        return new ResponseEntity<>(cinemaService.getIncassoCinema(cinemaId), HttpStatus.ACCEPTED);
    }
}
