package com.prjvitor.moedas_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prjvitor.moedas_api.models.Moeda;
import com.prjvitor.moedas_api.repositories.MoedaRepository;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository moedaRepository;

    public List<Moeda> listarTodas() {
        return moedaRepository.findAll();
    }

    public Optional<Moeda> buscarPorCodigo(String code) {
        return moedaRepository.findById(code);
    }

    public void salvarTodas(List<Moeda> moedas) {
        moedaRepository.saveAll(moedas);
    }
}
