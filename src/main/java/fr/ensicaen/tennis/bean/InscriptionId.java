package fr.ensicaen.tennis.bean;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class InscriptionId implements Serializable {
    private int numeroAdherent;
    private int codeTournoi;

    // Constructeur vide requis
    public InscriptionId() {}

    public InscriptionId(int numeroAdherent, int codeTournoi) {
        this.numeroAdherent = numeroAdherent;
        this.codeTournoi = codeTournoi;
    }

    // Getters & Setters
    public int getNumeroAdherent() { return numeroAdherent; }
    public void setNumeroAdherent(int numeroAdherent) { this.numeroAdherent = numeroAdherent; }

    public int getCodeTournoi() { return codeTournoi; }
    public void setCodeTournoi(int codeTournoi) { this.codeTournoi = codeTournoi; }

    // equals() et hashCode() obligatoires pour clé composite
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InscriptionId)) return false;
        InscriptionId that = (InscriptionId) o;
        return numeroAdherent == that.numeroAdherent &&
                codeTournoi == that.codeTournoi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroAdherent, codeTournoi);
    }
}
