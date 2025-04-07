package fr.ensicaen.tennis.bean;

import fr.ensicaen.tennis.persistence.AdherentEntity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Inscription")
public class Inscription {

    @EmbeddedId
    private InscriptionId id;

    @ManyToOne
    @MapsId("numeroAdherent")
    @JoinColumn(name = "numeroAdherent")
    private AdherentEntity adherent;

    @ManyToOne
    @MapsId("codeTournoi")
    @JoinColumn(name = "codeTournoi")
    private Tournoi tournoi;

    @Temporal(TemporalType.DATE)
    private Date dateInscription;

    // Getters & Setters

    public InscriptionId getId() {
        return id;
    }

    public void setId(InscriptionId id) {
        this.id = id;
    }

    public AdherentEntity getAdherent() {
        return adherent;
    }

    public void setAdherent(AdherentEntity adherent) {
        this.adherent = adherent;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
