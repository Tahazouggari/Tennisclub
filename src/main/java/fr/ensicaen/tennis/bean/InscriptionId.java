package fr.ensicaen.tennis.bean;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class InscriptionId implements Serializable {
    private int numeroAdherent;
    private int codeTournoi;

    public InscriptionId() {}

    public InscriptionId(int numeroAdherent, int codeTournoi) {
        this.numeroAdherent = numeroAdherent;
        this.codeTournoi = codeTournoi;
    }

    public int getNumeroAdherent() { return numeroAdherent; }
    public void setNumeroAdherent(int numeroAdherent) { this.numeroAdherent = numeroAdherent; }

    public int getCodeTournoi() { return codeTournoi; }
    public void setCodeTournoi(int codeTournoi) { this.codeTournoi = codeTournoi; }

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
