package ejb.entites;

@javax.persistence.Entity
public class OeuvrePeinture extends Oeuvre {
	private static final long serialVersionUID = 1L;
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
