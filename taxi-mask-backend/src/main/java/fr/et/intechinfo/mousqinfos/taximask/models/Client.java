package fr.et.intechinfo.mousqinfos.taximask.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "clients")
public class Client extends Utilisateur  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(name = "nomEntreprise")
	private String nomEntreprise;
	
	@Column(name = "pays")
	private String pays;
	
	@Column(name = "adresse")
	private String adresse ;
	
	@Column(name = "codePostale")
	private int codePostale;
	
	@Column(name = "ville")
	private String ville;
	
	@Column(name = "mobile")
	private int mobile;
	
	
	@OneToMany(mappedBy = "client", cascade = {
	        CascadeType.ALL
	    })
	private List < Commande > commandes;
	
	@OneToMany(mappedBy = "client", cascade = {
	        CascadeType.ALL
	    })
	private List < Avis > avis;

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	
	public List < Avis > getAvis() {
		return avis;
	}

	public void setAvis(List < Avis > avis) {
		this.avis = avis;
	}

	
	

	
	

	

	
	

}
