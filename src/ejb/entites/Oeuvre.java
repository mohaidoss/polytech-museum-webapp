package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Inheritance(strategy=javax.persistence.InheritanceType.SINGLE_TABLE)
@Entity
@Table
public abstract class Oeuvre implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	public int getId(){
		return this.Id;
	}
	@Id
	@Column private int Id;
	@Column(length=1000) private String URL;
	@Column private String titre;
	@Column private int annee;
	
	@ManyToMany(fetch=FetchType.EAGER) private Set<Categorie> categories;
	@ManyToOne(fetch=FetchType.EAGER) private Artiste artiste;
	@Column private int score;
	@Column private int aime;
	@Column private int aimepas;
	@Column private int sansavis;

	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Artiste getArtiste() {
		return artiste;
	}
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	public int getScore() {
		return score;
	}
	public abstract void setScore();
	public void setId(int id) {
		Id = id;
	}
	
	public Set<Categorie> getCategories() {
		return categories;
	}
	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}
	public int getAime() {
		return aime;
	}
	public void setAime(int aime) {
		this.aime = aime;
	}
	public int getAimepas() {
		return aimepas;
	}
	public void setAimepas(int aimepas) {
		this.aimepas = aimepas;
	}
	public int getSansavis() {
		return sansavis;
	}
	public void setSansavis(int sansavis) {
		this.sansavis = sansavis;
	}
}
