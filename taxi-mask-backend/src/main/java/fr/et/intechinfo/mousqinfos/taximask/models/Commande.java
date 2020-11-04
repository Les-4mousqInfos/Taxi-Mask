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
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
	private Client client;



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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoitue() {
		return voiture;
	}

	public void setVoitue(Voiture voiture) {
		this.voiture = voiture;
	}

	

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	
	
	


}
