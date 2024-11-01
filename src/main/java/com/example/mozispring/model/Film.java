package com.example.mozispring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "filmek")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cim;
    private int ev;
    private int hossz;

    public Long getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public int getEv() {
        return ev;
    }

    public int getHossz() {
        return hossz;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }
}
