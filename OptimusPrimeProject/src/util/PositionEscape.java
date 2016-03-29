package util;

public class PositionEscape {

	public int positionShot;
	public int positionEscape;
	public int anguleEscape;
	public Double timeOfResistance;
	public int getPositionShot() {
		return positionShot;
	}
	public void setPositionShot(int positionShot) {
		this.positionShot = positionShot;
	}
	public int getPositionEscape() {
		return positionEscape;
	}
	public void setPositionEscape(int positionEscape) {
		this.positionEscape = positionEscape;
	}
	public int getAnguleEscape() {
		return anguleEscape;
	}
	public void setAnguleEscape(int anguleEscape) {
		this.anguleEscape = anguleEscape;
	}
	public Double getTimeOfResistance() {
		return timeOfResistance;
	}
	public void setTimeOfResistance(Double timeOfResistance) {
		this.timeOfResistance = timeOfResistance;
	}
	
	@Override
	public String toString() {
		return "PositionEscape [positionShot=" + positionShot
				+ ", positionEscape=" + positionEscape + ", anguleEscape="
				+ anguleEscape + ", timeOfResistance=" + timeOfResistance + "]";
	}
	
	public PositionEscape clone(){
		PositionEscape positionEscapeClone = new PositionEscape();
		positionEscapeClone.setAnguleEscape(this.getAnguleEscape());
		positionEscapeClone.setPositionEscape(this.getPositionEscape());
		positionEscapeClone.setPositionShot(this.getPositionShot());
		positionEscapeClone.setTimeOfResistance(this.getTimeOfResistance());
		return positionEscapeClone;
	}
	
	
}