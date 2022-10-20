package com.cinema.cinema.data.dto;

import com.cinema.cinema.service.ISconti;

public class ScontoGiovani implements ISconti {


    @Override
    public Double getSconto(Double prezzo, Integer eta) {
        return eta <= 5 ? prezzo * 0.5 : prezzo;
    }
}
