package fr.et.intechinfo.mousqinfos.taximask.models;

import java.util.Date;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "commandes")
@NoArgsConstructor
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "trappe")
	private String trappe;
	@Column(name = "typeProtection")
	private String typeProtection;
	@Column(name = "prixProtection")
	private double prixProtection;
	@Column(name = "toit")
	private String toit;
	@Column(name = "etiquette")
	private String etiquette;
	@CreationTimestamp
	private Date createdAt;
	@CreationTimestamp
	private Date updatedAt;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "voiture_id")
	private Voiture voiture;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "facture_id", referencedColumnName = "id", nullable = true)
	private Facture facture;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
	private Utilisateur utilisateur;
	@Transient
	private String tokenUn;
	@Transient
	private String type = "Bearer";

	public long getId() {
		return id;
	}


	public String getTrappe() {
		return trappe;
	}

	public void setTrappe(String trappe) {
		this.trappe = trappe;
	}

	public String getTypeProtection() {
		return typeProtection;
	}

	public void setTypeProtection(String typeProtection) {
		this.typeProtection = typeProtection;
	}

	public double getPrixProtection() {
		return prixProtection;
	}

	public void setPrixProtection(double prixProtection) {
		this.prixProtection = prixProtection;
	}

	public String getToit() {
		return toit;
	}

	public void setToit(String toit) {
		this.toit = toit;
	}

	public String getEtiquette() {
		return etiquette;
	}

	public void setEtiquette(String etiquette) {
		this.etiquette = etiquette;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getTokenUn() {
		return tokenUn;
	}

	public void setTokenUn(String tokenUn) {
		this.tokenUn = tokenUn;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Commande{" +
				"id=" + id +
				", trappe='" + trappe + '\'' +
				", typeProtection='" + typeProtection + '\'' +
				", prixProtection=" + prixProtection +
				", toit='" + toit + '\'' +
				", etiquette='" + etiquette + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				", voiture=" + voiture +
				", facture=" + facture +
				", client=" + utilisateur +
				'}';
	}
}
