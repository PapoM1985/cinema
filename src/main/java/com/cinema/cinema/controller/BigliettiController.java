package com.cinema.cinema.controller;

import com.cinema.cinema.data.dto.BigliettiDto;
import com.cinema.cinema.data.dto.SpettatoriDto;
import com.cinema.cinema.data.model.Spettatori;
import com.cinema.cinema.service.BigliettiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biglietti")
public class BigliettiController {

    private BigliettiService bigliettiService;

    public BigliettiController(BigliettiService bigliettiService) {
        this.bigliettiService = bigliettiService;
    }

    @GetMapping
    public ResponseEntity<List<BigliettiDto>> getAll() {
        return new ResponseEntity<>(bigliettiService.getAllBiglietti(), HttpStatus.OK);
    }

    @GetMapping("/{bigliettoId}")
    public ResponseEntity<BigliettiDto> getById(@PathVariable String bigliettoId) {
        return new ResponseEntity<>(bigliettiService.getBiglietto(bigliettoId), HttpStatus.OK);
    }

    @GetMapping("/biglietto/{spettatoreId}")
    public ResponseEntity<BigliettiDto> generaBiglietto(@PathVariable String spettatoreId,@PathVariable String filmId){
        return new ResponseEntity<>( bigliettiService.generaBiglietti(spettatoreId,filmId), HttpStatus.OK);
    }

    @DeleteMapping("/{bigliettoId}")
    public ResponseEntity<String> delete(@PathVariable String bigliettoId) {
        bigliettiService.deleteById(bigliettoId);
        return new ResponseEntity<>("Biglietto eliminato", HttpStatus.OK);
    }
}
