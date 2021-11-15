package ejb.entites;

@javax.persistence.Entity
public class OeuvrePeinture extends Oeuvre {
	private static final long serialVersionUID = 1L;
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore() {
		this.score = this.getAime() - this.getAimepas();
		if (this.score < 0)
			this.score = 0;
	}
	
}
