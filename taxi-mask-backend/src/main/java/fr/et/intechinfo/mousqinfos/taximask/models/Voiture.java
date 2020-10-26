package fr.et.intechinfo.mousqinfos.taximask.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "voitures")
public class Voiture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "marque")
	private String marque;
	
	@Column(name = "modele")
	private String modele;
	
	@Column(name = "immatriculation")
	private String immatriculation;
	
	@Column(name = "DatePreImma")
	private Date DatePreimma;
	
	@Column(name = "photoCarteGrise")
	private String photoCarteGrise;
	
	@Column(name = "photoVoiture")
	private String photoVoiture;
	
	
	
	@CreationTimestamp
	private Date createdAt;

	@CreationTimestamp
	private Date updatedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Date getDatePreimma() {
		return DatePreimma;
	}

	public void setDatePreimma(Date datePreimma) {
		DatePreimma = datePreimma;
	}

	public String getPhotoCarteGrise() {
		return photoCarteGrise;
	}

	public void setPhotoCarteGrise(String photoCarteGrise) {
		this.photoCarteGrise = photoCarteGrise;
	}

	public String getPhotoVoiture() {
		return photoVoiture;
	}

	public void setPhotoVoiture(String photoVoiture) {
		this.photoVoiture = photoVoiture;
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

	
	
	
}
