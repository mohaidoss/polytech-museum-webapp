package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManyToMany(mappedBy="categories") Set<Oeuvre> oeuvres;
	@Id
	@Column private String Intitule;
	
	public void setIntitule(String intitule) {
		Intitule = intitule;
	}
	
	public String getIntitule(){
		return this.Intitule;
	}

	public Set<Oeuvre> getOeuvres() {
		return oeuvres;
	}
	public void setOeuvres(Set<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	
}
