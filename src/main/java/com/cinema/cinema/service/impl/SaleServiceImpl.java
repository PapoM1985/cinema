package com.cinema.cinema.service.impl;

import com.cinema.cinema.data.dto.Incassi;
import com.cinema.cinema.data.dto.SaleDto;
import com.cinema.cinema.data.model.Sale;
import com.cinema.cinema.exception.ResourceNotFoundException;
import com.cinema.cinema.exception.UnexpectedException;
import com.cinema.cinema.repository.SaleRepository;
import com.cinema.cinema.service.SaleService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepo;

    public SaleServiceImpl(SaleRepository saleRepo) {
        this.saleRepo = saleRepo;
    }

    @Override
    public List<SaleDto> getAllSale(){
        List<SaleDto> saleDtoList = new ArrayList<>();
        for (Sale saleToConvert:saleRepo.findAll()) {
            saleDtoList.add(saleToConvert.toDto());
        }
        return saleDtoList;
    }

    @Override
    public SaleDto getSale(String salaId){
        Sale sala = saleRepo.findById(salaId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale", "salaId", salaId));
        return sala.toDto();
    }

    @Override
    public Incassi getIncassoSala(String salaId){
        Sale sala = getSale(salaId).toModel();
        return saleRepo.incassoSala(salaId);
    }

    @Override
    public SaleDto createSala(SaleDto salaNew){
        return saleRepo.save(salaNew.toModel()).toDto();
    }

    @Override
    public SaleDto aggiornaSala(SaleDto salaUpdate){
        SaleDto saleToUpdate = getSale(salaUpdate.getSalaId());
        saleToUpdate.setPostiDisponibili(salaUpdate.getPostiDisponibili() - 1);
        return saleRepo.save(saleToUpdate.toModel()).toDto();
    }

    @Override
    public String svuotaSala(String salaId){
        Sale salaToReset = getSale(salaId).toModel();
        salaToReset.setPostiDisponibili(0);
        saleRepo.save(salaToReset);
        return "La sala è stata svuota";
    }

    @Override
    public Boolean controllaDisponibilitaPosto(Sale sale){
        if (sale.getPostiDisponibili()<=0){
            throw new UnexpectedException("La sala %s è al completo. \n %s posti risultano occupati",sale.getNome(),sale.getPostiTotali().toString());
        } else {
            return Boolean.TRUE;
        }
    }



}
