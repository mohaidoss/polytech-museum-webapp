package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Article implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	public int getNum(){
		return this.Num;
	}
	
	@Column private int Num;
	@Column private String Nom;
	@Column private String Prenom;
}
