package com.cinema.cinema.controller;

import com.cinema.cinema.data.dto.SpettatoriDto;
import com.cinema.cinema.data.model.Spettatori;
import com.cinema.cinema.service.SpettatoriService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spettatori")
public class SpettatoriController {

    private SpettatoriService spettatoriService;

    public SpettatoriController(SpettatoriService spettatoriService) {
        this.spettatoriService = spettatoriService;
    }

    @GetMapping
    public ResponseEntity<List<SpettatoriDto>> getAll() {
        return new ResponseEntity<>(spettatoriService.getAllSpettatori(), HttpStatus.OK);
    }

    @GetMapping("/{spettatoreId}")
    public ResponseEntity<SpettatoriDto> getById(@PathVariable String spettatoreId) {
        return new ResponseEntity<>(spettatoriService.getSpettatore(spettatoreId), HttpStatus.OK);
    }

    @GetMapping("/checkEta/{spettatoreId}/film/{filmId}")
    public ResponseEntity<Boolean> controlloEta(@PathVariable String spettatoreId,@PathVariable String filmId){
        return new ResponseEntity<>(spettatoriService.controlloSeMinorenne(spettatoreId,filmId), HttpStatus.OK);
    }

    @GetMapping("/search/cognome/{cognome}/nome/{nome}")
    public ResponseEntity<List<Spettatori>> cercaSpettatore(@PathVariable String cognome, @PathVariable String nome){
        return new ResponseEntity<>(spettatoriService.cercaSpettatore(cognome,nome), HttpStatus.OK);
    }

    @GetMapping("/eta/{spettatoreId}")
    public ResponseEntity<String> getEta(@PathVariable String spettatoreId){
        return new ResponseEntity<>(spettatoriService.getEta(spettatoreId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> registraSpettatore(@RequestBody SpettatoriDto spettatore) {
        try {
            spettatoriService.nuovoSpettatore(spettatore);
            return new ResponseEntity<>("Nuovo spettatore registrato", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
