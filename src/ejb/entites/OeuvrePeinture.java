package ejb.entites;

@javax.persistence.Entity
public class OeuvrePeinture extends Oeuvre {
	private static final long serialVersionUID = 1L;
	private int aime;
	private int aimepas;
	private int sansavis;
	
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
