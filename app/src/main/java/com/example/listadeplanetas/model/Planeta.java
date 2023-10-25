package com.example.listadeplanetas.model;

import java.io.Serializable;

public class Planeta implements Serializable {

    private Long id;
    private String nomePlaneta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePlaneta() {
        return nomePlaneta;
    }

    public void setNomePlaneta(String nomePlaneta) {
        this.nomePlaneta = nomePlaneta;
    }
}
