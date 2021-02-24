package ejb.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class Oeuvre implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	public int getId(){
		return this.Id;
	}
	@Column private int Id;
	@Column(length = 100) private String URL;
	@Column private String titre;
	@Column private int annee;
}
