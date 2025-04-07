package fr.ensicaen.tennis.persistence;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tournoi", schema = "PUBLIC", catalog = "tennis")
public class TournoiEntity {
    private int codeTournoi;
    private String nom;
    private Date date;
    private String lieu;
    private List<InscriptionEntity> inscriptions;

    @Id
    @Column(name = "codeTournoi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCodeTournoi() {
        return codeTournoi;
    }
    public void setCodeTournoi(int codeTournoi) {
        this.codeTournoi = codeTournoi;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 100)
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "lieu", length = 100)
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @OneToMany(mappedBy = "tournoi")
    public List<InscriptionEntity> getInscriptions() {
        return inscriptions;
    }
    public void setInscriptions(List<InscriptionEntity> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
