package util;

public class LastPosition extends PositionEscape {
	
	private Long shotTime= new Long(0);
	private Long timeToNextShot = new Long(0);
	
	public LastPosition(PositionEscape positionEscape){
		this.anguleEscape = positionEscape.getAnguleEscape();
		this.positionEscape = positionEscape.getPositionEscape();
		this.positionShot = positionEscape.getPositionShot();
		this.timeOfResistance = positionEscape.getTimeOfResistance();
	}

	public Long getShotTime() {
		return shotTime;
	}

	public void setShotTime(Long shotTime) {
		this.shotTime = shotTime;
	}

	public Long getTimeToNextShot() {
		return timeToNextShot;
	}

	public void setTimeToNextShot(Long timeToNextShot) {
		this.timeToNextShot = timeToNextShot;
	}

	@Override
	public String toString() {
		return "LastPosition [shotTime=" + shotTime + ", timeToNextShot="
				+ timeToNextShot + "]";
	}
	
	
}
