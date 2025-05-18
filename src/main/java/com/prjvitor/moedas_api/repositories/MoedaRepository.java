package com.prjvitor.moedas_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prjvitor.moedas_api.models.Moeda;

public interface MoedaRepository extends JpaRepository<Moeda, String> {
}
