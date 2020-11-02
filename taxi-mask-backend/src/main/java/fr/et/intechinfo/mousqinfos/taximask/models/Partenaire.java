package fr.et.intechinfo.mousqinfos.taximask.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "partenaires")
public class Partenaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "url")
	private String url;
	
	
	@Column(name = "nom")
	private String nom;
	
	
	@Column(name = "logo")
	private String logo;

	
	@CreationTimestamp
	private Date createdAt;

	@CreationTimestamp
	private Date updatedAt;

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	

}
