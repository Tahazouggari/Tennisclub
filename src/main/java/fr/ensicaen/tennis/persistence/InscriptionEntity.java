package fr.ensicaen.tennis.persistence;

import fr.ensicaen.tennis.bean.InscriptionId;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Inscription", schema = "PUBLIC", catalog = "tennis")
@IdClass(InscriptionId.class)
public class InscriptionEntity {
    private int numeroAdherent;
    private int codeTournoi;
    private Date dateInscription;
    private AdherentEntity adherent;
    private TournoiEntity tournoi;

    @Id
    @Column(name = "numeroAdherent")
    public int getNumeroAdherent() {
        return numeroAdherent;
    }
    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }

    @Id
    @Column(name = "codeTournoi")
    public int getCodeTournoi() {
        return codeTournoi;
    }
    public void setCodeTournoi(int codeTournoi) {
        this.codeTournoi = codeTournoi;
    }

    @Basic
    @Column(name = "dateInscription")
    @Temporal(TemporalType.DATE)
    public Date getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    @ManyToOne
    @JoinColumn(name = "numeroAdherent", insertable = false, updatable = false)
    public AdherentEntity getAdherent() {
        return adherent;
    }
    public void setAdherent(AdherentEntity adherent) {
        this.adherent = adherent;
    }

    @ManyToOne
    @JoinColumn(name = "codeTournoi", insertable = false, updatable = false)
    public TournoiEntity getTournoi() {
        return tournoi;
    }
    public void setTournoi(TournoiEntity tournoi) {
        this.tournoi = tournoi;
    }
}
