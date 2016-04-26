package optimusBeta;
import robocode.*;
//import java.awt.Color;

/**
 * OptimusBeta - a robot by (luucasAlbuq)
 */
public class OptimusBeta extends Robot
{
	/**
	 * run: OptimusBeta's default behavior
	 */
	public void run() {
		
		while(true) {
			ahead(100);
			turnGunRight(360);
			turnLeft(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if(e.getDistance() <= 200){
			fire(3);
		}else{
			fire(1);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(100);
		turnRight(100);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
