package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Categorie implements Serializable{
	public void setIntitule(String intitule) {
		Intitule = intitule;
	}

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	public String getIntitule(){
		return this.Intitule;
	}
	
	@Column private String Intitule;
	
}
