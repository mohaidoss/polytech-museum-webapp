package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Artiste implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column private int Num;
	@OneToMany(mappedBy="artiste") private Set<Oeuvre> oeuvres;
	@Column private String Nom;
	@Column private String Prenom;
	
	public int getNum(){
		return this.Num;
	}
	
	public Set<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(Set<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public void setNum(int num) {
		Num = num;
	}

}
