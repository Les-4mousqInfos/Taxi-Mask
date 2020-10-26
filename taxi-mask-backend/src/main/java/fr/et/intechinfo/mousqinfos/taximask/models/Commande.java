package fr.et.intechinfo.mousqinfos.taximask.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "commandes")
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
	@JoinColumn(name = "voiture_id", referencedColumnName = "id")
	private Voiture voitue;
	
	@OneToOne(mappedBy = "facture")
    private Facture facture;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return voitue;
	}

	public void setVoitue(Voiture voitue) {
		this.voitue = voitue;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	
	
	


}
