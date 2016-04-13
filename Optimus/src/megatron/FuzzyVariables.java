package megatron;

public class FuzzyVariables {
	
	 double energy;
	 double energyEnemy;
	 double bearingFromGun;
	 double lastBearingFronGun;
	 double closeDistance;
	 double farDistance;
	 double lowEnergy;
	 double highEnergy;
	 double lowAggress;
	 double moderateAggress;
	 double highAggress;
	 double precision;
	
	public FuzzyVariables(){};
	
	public void inicialize(){
		energyEnemy = 0;
		bearingFromGun = 0;
		lastBearingFronGun= 0;
		closeDistance = 0;
		farDistance = 0;
		lowEnergy = 0;
		highEnergy = 0;
		lowAggress = 0;
		moderateAggress = 0;
		highAggress = 0;
		precision = 0.01;
	}
}
