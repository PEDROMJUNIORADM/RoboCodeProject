package optimus;

/**
 * Define how the robot will move.
 * 
 * @author Lucas
 *
 */
public class MovementRobot {
	
	public double front = 0;
	public double back = 0;
	public double rigth = 0;
	public double left = 0;
	
	public MovementRobot(){}
	
	public MovementRobot(double front, double back, double rigth, double left) {
		this.front = front;
		this.back = back;
		this.rigth = rigth;
		this.left = left;
	}
}