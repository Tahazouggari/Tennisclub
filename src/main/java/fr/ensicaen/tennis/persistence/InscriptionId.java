package fr.ensicaen.tennis.persistence;

import java.io.Serializable;
import java.util.Objects;

public class InscriptionId implements Serializable {
    private int numeroAdherent;
    private int codeTournoi;

    public InscriptionId() {}

    public InscriptionId(int numeroAdherent, int codeTournoi) {
        this.numeroAdherent = numeroAdherent;
        this.codeTournoi = codeTournoi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InscriptionId)) return false;
        InscriptionId that = (InscriptionId) o;
        return numeroAdherent == that.numeroAdherent && codeTournoi == that.codeTournoi;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroAdherent, codeTournoi);
    }
}
