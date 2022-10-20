package com.cinema.cinema.data.dto;

import com.cinema.cinema.service.ISconti;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScontoGiovani implements ISconti {

    private Double prezzo;

    @Override
    public Double getSconto(Double prezzo) {
        return  prezzo * 0.5;
    }
}
