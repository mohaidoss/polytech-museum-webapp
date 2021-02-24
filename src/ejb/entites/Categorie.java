package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	public int getIntitule(){
		return this.Intitule;
	}
	
	@Column private String Intitule;
	
}
