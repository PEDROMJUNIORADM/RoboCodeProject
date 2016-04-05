package optimus;

public class Shot {
	
	/* Number of bullets */
	public int bullets;
	
	/* firepower for each bullet */
	public double power;

	/**
	 * Build a bullet 
	 * 
	 * @param bullets
	 * @param power
	 */
	public Shot(int bullets, double power) {
		this.bullets = bullets;
		this.power = power;
	}
}