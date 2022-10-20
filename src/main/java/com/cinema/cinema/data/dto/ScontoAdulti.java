package com.cinema.cinema.data.dto;

import com.cinema.cinema.service.ISconti;

public class ScontoAdulti implements ISconti {

    @Override
    public Double getSconto(Double prezzo, Integer eta) {
        return eta >= 70 ? prezzo * 0.9 : prezzo;
    }
}
