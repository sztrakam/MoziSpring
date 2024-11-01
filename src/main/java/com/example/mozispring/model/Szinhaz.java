package com.example.mozispring.model;

import jakarta.persistence.*;
@Entity
@Table(name = "szinhazak")
public class Szinhaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;
    private String varos;
    private int ferohely;

    public Long getId() {
        return id;
    }

    public String getNev() {
        return nev;
    }

    public String getVaros() {
        return varos;
    }

    public int getFerohely() {
        return ferohely;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public void setFerohely(int ferohely) {
        this.ferohely = ferohely;
    }
}

