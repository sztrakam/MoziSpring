package com.example.mozispring.model;

import jakarta.persistence.*;
@Entity
@Table(name = "eloadas")
public class Eloadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int moziid;
    private String datum;
    private int nezoszam;
    private int bevetel;

    public Long getId() {
        return id;
    }

    public int getMoziid() {
        return moziid;
    }

    public String getDatum() {
        return datum;
    }

    public int getNezoszam() {
        return nezoszam;
    }

    public int getBevetel() {
        return bevetel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMoziid(int moziid) {
        this.moziid = moziid;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setNezoszam(int nezoszam) {
        this.nezoszam = nezoszam;
    }

    public void setBevetel(int bevetel) {
        this.bevetel = bevetel;
    }
}

