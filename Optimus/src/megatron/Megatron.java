package megatron;

import static robocode.util.Utils.normalRelativeAngleDegrees;

import java.awt.Color;

import robocode.*;

public class Megatron extends AdvancedRobot {
	
	 double energy;
	 double energyEnemy = 0;
	 double bearingFromGun = 0;
	 double lastBearingFronGun = 0;
	 double closeDistance = 0;
	 double farDistance = 0;
	 double lowEnergy = 0;
	 double highEnergy = 0;
	 double lowAggress = 0;
	 double moderateAggress = 0;
	 double highAggress = 0;
	 double precision = 0.05;
	
	 /**
	  * Run, Forrest, Run!
	  */
	 public void run(){
		 wear();
		 while(true){
			 energy = this.getEnergy();
			 if(lastBearingFronGun <= 0){
				 turnLeft(10);
			 }else{
				 turnRight(10);
			 }
		 }
	 }
	 
	 private void wear(){
		 setBodyColor(Color.red);
		 setGunColor(Color.yellow);
		 setRadarColor(Color.white);
		 setBulletColor(Color.cyan);
		 setScanColor(Color.cyan);
	 }
	 
	 	/**
		 * onScannedRobot: what to do when you have a target 
		 */
		public void onScannedRobot(ScannedRobotEvent e) {
			energy = this.getEnergy();
			energyEnemy = e.getEnergy();
			double absoluteBearing = getHeading() + e.getBearing();
			lastBearingFronGun = bearingFromGun;
			bearingFromGun = normalRelativeAngleDegrees(absoluteBearing	- getGunHeading());
			
			if (Math.abs(bearingFromGun) <= 3) {
				turnRight(bearingFromGun);
				if (getGunHeat() == 0) {
					controleNebuloso(e);
				}
			} else {
				turnRight(bearingFromGun);
			}
			
			if (bearingFromGun == 0) {
				scan();
			}
		}
		
		public void onHitRobot(HitRobotEvent e) {
			back(20);
		}
		
		/**
		 * onHitWall: What to do when you hit a wall
		 */
		public void onHitWall(HitWallEvent e) {
			 back(500);
			 turnRight(90);
			 ahead(100);
		}
		
		public void controleNebuloso(ScannedRobotEvent e) {
			fuzificarDist(e.getDistance());
			fuzificarenergy(this.energy);
			resetAgressividade();
			gerarAgressividade();
			
			double forcaTiro = defuzificar();
			//double forcaTiro = atirar(e.getDistance());
			fire(forcaTiro);
			System.out.println(forcaTiro);
			
			ahead(10);
		}
		
		private void fuzificarDist(double dist) {
			if (dist <= 200) {
				closeDistance = 1.0;
				farDistance = 0.0;
			} else if (dist > 200 && dist < 300) {
				closeDistance = (300.0 - dist)/100.0;
				farDistance = (dist - 200.0)/100.0;
			} else {
				closeDistance = 0.0;
				farDistance = 1.0;
			}
		}
		
		private void fuzificarenergy(double energy) {
			if (energy <= 30.0) {
				lowEnergy = 1.0;
				highEnergy = 0.0;
			} else if (energy > 30.0 && energy < 50.0) {
				lowEnergy = (50.0 - energy)/20.0;
				highEnergy = (energy - 30.0)/20.0;
			} else {
				lowEnergy = 0.0;
				highEnergy = 1.0;
			}
		}
		
		private void resetAgressividade() {
			lowAggress = 0.0;
			moderateAggress = 0.0;
			highAggress = 0.0;
		}
		
		private double atirar(double dist){
			double forcaTiro = 0;
			if(dist <= 200){
				// Se a arma estiver pronta
				if (getGunHeat() == 0) {
					   /* forca do tiro vai ser igual a porcentagem da agressividade
					    *  multiplicada pela forca maxima do tiro
					    */
					forcaTiro = Rules.MAX_BULLET_POWER * highAggress;
				}
			}else if( dist > 200 && dist < 300){
				forcaTiro =  Rules.MAX_BULLET_POWER * moderateAggress;
			}else{
				forcaTiro =  Rules.MAX_BULLET_POWER * lowAggress;
			}
			
			return forcaTiro;
		}
		
		private double defuzificar() {
			double outputLevel = 0.0;
			double controller = 0.0;
			
			for (double i = 0.0; i <= 3.0; i+=precision) {
				
				//Agressividade Baixa
				if (i >= 0.0 && i < 1.0) {
					if (lowAggress != 0) {
						outputLevel += lowAggress*i;
						controller++;
					}
				}
				
				//Agressividade Baixa-Media
				else if (i >= 1.0 && i <= 1.5) {
					if (lowAggress > moderateAggress) {
						if (lowAggress > 0) {
							outputLevel += lowAggress*i;
							controller++;
						}
					} else {
						if (moderateAggress > 0) {
							outputLevel += moderateAggress*i;
							controller++;
						}
					}
				}
				
				//Agressividade Media
				else if (i > 1.5 && i < 2.0) {
					if (moderateAggress > 0) {
						outputLevel += moderateAggress*i;
						controller++;
					}
				}
				
				//Agressividade Media-Alta
				else if (i >= 2.0 && i <= 2.5) {
					if (moderateAggress > highAggress) {
						if (moderateAggress > 0) {
							outputLevel += moderateAggress*i;
							controller++;
						}
					} else {
						if (highAggress > 0) {
							outputLevel += highAggress*i;
							controller++;
						}
					}
				}
				
				//Agressividade Alta
				else if (i > 2.5) {
					if (highAggress > 0) {
						outputLevel += highAggress*i;
						controller++;
					}
				}		
			}
			
			outputLevel /= controller;
			
			return outputLevel;
		}
		
		private void gerarAgressividade() {
			//Energia = Alta
			if (highEnergy > 0.0) {
				//Distancia = Perto
				if (closeDistance > 0.0) {
					highAggress += highEnergy * closeDistance;
				} 
				//Distancia = Longe
				if (farDistance > 0.0) {
					moderateAggress += highEnergy * farDistance;
				}	
			}
			//Energia = Baixa
			if (lowEnergy > 0.0) {
				//Distancia = Perto
				if (closeDistance > 0.0) {
					moderateAggress += lowEnergy * closeDistance;
				} 
				//Distancia = Longe
				if (farDistance > 0.0) {
					lowAggress += lowEnergy * farDistance;
				}
			}
		}
}
