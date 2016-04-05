package optimus;

public class LastPosition extends EscapePosition {
	
	Long timeShot = new Long(0);
	Long timeToNextShot = new Long(0);
	
	public LastPosition(EscapePosition positionEscape){
		this.angleEscape = positionEscape.getAngleEscape();
		this.escapeDiretion = positionEscape.getEscapeDiretion();
		this.shotDiretion = positionEscape.getShotDiretion();
		this.timeOfResistance = positionEscape.getTimeOfResistance();
	}
	
	
	public Long getTimeShot() {
		return timeShot;
	}
	public void setTimeShot(Long timeShot) {
		this.timeShot = timeShot;
	}
	public Long getTimeToNextShot() {
		return timeToNextShot;
	}
	public void setTimeToNextShot(Long timeToNextShot) {
		this.timeToNextShot = timeToNextShot;
	}
	
	
	@Override
	public String toString(){

		String retorno = shotDiretion+";"+escapeDiretion+";"+angleEscape+";"+timeOfResistance+";"+timeShot+";"+timeToNextShot+"|";
			
		return retorno;
		
	}
	
	

}
