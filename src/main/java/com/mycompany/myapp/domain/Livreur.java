package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Livreur.
 */
@Entity
@Table(name = "livreur")
public class Livreur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "nb_earnings")
    private Integer nbEarnings;

    @Column(name = "nb_rides")
    private Integer nbRides;

    @Column(name = "transporter_rating")
    private String transporterRating;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "livreur")
    @JsonIgnoreProperties(value = { "client", "livreur", "commercant" }, allowSetters = true)
    private Set<Commande> commandes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Livreur id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public Livreur vehicleType(String vehicleType) {
        this.setVehicleType(vehicleType);
        return this;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getNbEarnings() {
        return this.nbEarnings;
    }

    public Livreur nbEarnings(Integer nbEarnings) {
        this.setNbEarnings(nbEarnings);
        return this;
    }

    public void setNbEarnings(Integer nbEarnings) {
        this.nbEarnings = nbEarnings;
    }

    public Integer getNbRides() {
        return this.nbRides;
    }

    public Livreur nbRides(Integer nbRides) {
        this.setNbRides(nbRides);
        return this;
    }

    public void setNbRides(Integer nbRides) {
        this.nbRides = nbRides;
    }

    public String getTransporterRating() {
        return this.transporterRating;
    }

    public Livreur transporterRating(String transporterRating) {
        this.setTransporterRating(transporterRating);
        return this;
    }

    public void setTransporterRating(String transporterRating) {
        this.transporterRating = transporterRating;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Livreur user(User user) {
        this.setUser(user);
        return this;
    }

    public Set<Commande> getCommandes() {
        return this.commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        if (this.commandes != null) {
            this.commandes.forEach(i -> i.setLivreur(null));
        }
        if (commandes != null) {
            commandes.forEach(i -> i.setLivreur(this));
        }
        this.commandes = commandes;
    }

    public Livreur commandes(Set<Commande> commandes) {
        this.setCommandes(commandes);
        return this;
    }

    public Livreur addCommande(Commande commande) {
        this.commandes.add(commande);
        commande.setLivreur(this);
        return this;
    }

    public Livreur removeCommande(Commande commande) {
        this.commandes.remove(commande);
        commande.setLivreur(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Livreur)) {
            return false;
        }
        return id != null && id.equals(((Livreur) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Livreur{" +
            "id=" + getId() +
            ", vehicleType='" + getVehicleType() + "'" +
            ", nbEarnings=" + getNbEarnings() +
            ", nbRides=" + getNbRides() +
            ", transporterRating='" + getTransporterRating() + "'" +
            "}";
    }
}
