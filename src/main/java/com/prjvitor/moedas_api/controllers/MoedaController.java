package com.prjvitor.moedas_api.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prjvitor.moedas_api.models.Moeda;
import com.prjvitor.moedas_api.services.MoedaService;

@RestController
@RequestMapping("/moedas")
public class MoedaController {

    @Autowired
    private MoedaService moedaService;

    @GetMapping
    public List<Moeda> listarTodas() {
        return moedaService.listarTodas();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Moeda> buscarPorCodigo(@PathVariable String code) {
        return moedaService.buscarPorCodigo(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/{code}/flag", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody ResponseEntity<byte[]> buscarFlagPorCodigo(@PathVariable String code) {
        return moedaService.buscarPorCodigo(code)
                .map(moeda -> {
                    String base64Image = moeda.getFlag();
                    if (base64Image != null && base64Image.startsWith("data:image/png;base64,")) {
                        base64Image = base64Image.replace("data:image/png;base64,", "");
                    }
                    byte[] imageBytes = java.util.Base64.getDecoder().decode(base64Image);
                    return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageBytes);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
