package com.prjvitor.moedas_api;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prjvitor.moedas_api.models.Moeda;
import com.prjvitor.moedas_api.services.MoedaService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private MoedaService moedaService;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/moedas.json");

        if (inputStream != null) {
            List<Moeda> moedas = mapper.readValue(inputStream, new TypeReference<List<Moeda>>() {});
            moedaService.salvarTodas(moedas);
        }
    }
}