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
	@Column private String intitule;
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public String getIntitule(){
		return this.intitule;
	}

	public Set<Oeuvre> getOeuvres() {
		return oeuvres;
	}
	public void setOeuvres(Set<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}

	
}
