package optimus;

public class EscapePosition {
	
	public int shotDiretion;
	public int escapeDiretion;
	public int angleEscape;
	public Double timeOfResistance;
	
	
	public Double getTimeOfResistance() {
		return timeOfResistance;
	}
	public void setTimeOfResistance(Double timeOfResistance) {
		this.timeOfResistance = timeOfResistance;
	}
	public int getShotDiretion() {
		return shotDiretion;
	}
	public void setShotDiretion(int shotDiretion) {
		this.shotDiretion = shotDiretion;
	}
	public int getEscapeDiretion() {
		return escapeDiretion;
	}
	public void setEscapeDiretion(int escapeDiretion) {
		this.escapeDiretion = escapeDiretion;
	}
	public int getAngleEscape() {
		return angleEscape;
	}
	public void setAngleEscape(int angleEscape) {
		this.angleEscape = angleEscape;
	}
	
	public String toString(){
		
		String retorno = shotDiretion+";"+escapeDiretion+";"+angleEscape+";"+timeOfResistance+"|";
		
		return retorno;
	}
	
	
	public EscapePosition clone(){
		EscapePosition posicaoFugaClone = new EscapePosition();
		posicaoFugaClone.setAngleEscape(this.getAngleEscape());
		posicaoFugaClone.setEscapeDiretion(this.getEscapeDiretion());
		posicaoFugaClone.setShotDiretion(this.getShotDiretion());
		posicaoFugaClone.setTimeOfResistance(this.getTimeOfResistance());
		
		return posicaoFugaClone;
	}
	
	

}
