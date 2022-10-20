package com.cinema.cinema.controller;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.dto.SaleDto;
import com.cinema.cinema.service.SaleService;
import liquibase.pro.packaged.S;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSale(){
        return new ResponseEntity<>(saleService.getAllSale(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/incasso/sala/{salaId}")
    public ResponseEntity<Incassi> getincassoSala(@PathVariable String salaId){
        return new ResponseEntity<>(saleService.getIncassoSala(salaId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/svuota/sala/{salaId}")
    public ResponseEntity<String> svuotaSala(@PathVariable String salaId){
        return new ResponseEntity<>(saleService.svuotaSala(salaId), HttpStatus.ACCEPTED);
    }


}
