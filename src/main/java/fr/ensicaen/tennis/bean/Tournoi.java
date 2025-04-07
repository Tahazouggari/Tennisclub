package fr.ensicaen.tennis.bean;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tournoi")
public class Tournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeTournoi;

    private String nom;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String lieu;

    @OneToMany(mappedBy = "tournoi", fetch = FetchType.LAZY)
    private List<Inscription> inscriptions;

    // --- Getters & Setters ---

    public int getCodeTournoi() {
        return codeTournoi;
    }

    public void setCodeTournoi(int codeTournoi) {
        this.codeTournoi = codeTournoi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
