package com.cinema.cinema.service;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.dto.SaleDto;
import com.cinema.cinema.data.model.Sale;

import java.sql.Timestamp;
import java.util.List;

public interface SaleService {

    List<SaleDto> getAllSale();
    SaleDto getSale(String salaId);
    Incassi getIncassoSala(String salaId);
    SaleDto createSala(SaleDto salaNew);
    String svuotaSala(String salaId);
    Boolean controllaDisponibilitaPosto(Sale sale);
    SaleDto aggiornaSala(SaleDto salaUpdate);

}
