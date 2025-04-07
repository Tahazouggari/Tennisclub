package fr.ensicaen.tennis.persistence;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Adherent")
@Table(name = "Adherent", schema = "PUBLIC", catalog = "tennis")
public class AdherentEntity {
    private int numeroAdherent;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String password;
    private List<InscriptionEntity> inscriptions;


    @Id
    @Column(name = "numeroAdherent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getNumeroAdherent() {
        return numeroAdherent;
    }

    public void setNumeroAdherent(int numeroAdherent) {
        this.numeroAdherent = numeroAdherent;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "adresse", length = 100)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "telephone", length = 20)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "email", nullable = false, unique = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @OneToMany(mappedBy = "adherent")
    public List<InscriptionEntity> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<InscriptionEntity> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
