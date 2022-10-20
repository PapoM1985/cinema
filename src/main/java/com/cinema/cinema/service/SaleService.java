package com.cinema.cinema.service;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.dto.SaleDto;

import java.sql.Timestamp;
import java.util.List;

public interface SaleService {

    List<SaleDto> getAllSale();
    SaleDto getSale(String salaId);
    Incassi getIncassoSala(String salaId, Timestamp dataIncasso);
    SaleDto createSala(SaleDto salaNew);

}
