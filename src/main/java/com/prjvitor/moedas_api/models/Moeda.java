package com.prjvitor.moedas_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "moedas")
@Data
public class Moeda {
    
    
    @Id
    private String code;

    private String name;

    private String country;

    private String countryCode;

    @Column(columnDefinition = "TEXT")
    private String flag;

}
