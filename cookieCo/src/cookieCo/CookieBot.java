package cookieCo;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.RobotDeathEvent;
//import robocode.Robot;
import robocode.ScannedRobotEvent;

import robocode.util.Utils;
import robocode.AdvancedRobot;

public class CookieBot extends AdvancedRobot{

	/**
	 * run: RoboCookie's default behavior
	 */
	int	startrobots;
	String target="NULLNULLNULL";
	 //how many times to scan for target before giving up
	double[] x;
	double[] y;
	double[] energy;
	double[] bearing;
	double[] distance;
	double[] velocity;
	String[] names;
	
	public void run() {


		startrobots=getOthers();
		x = new double[startrobots];
		y = new double[startrobots];
		energy = new double[startrobots];
		bearing = new double[startrobots];
		distance = new double[startrobots];
		velocity = new double[startrobots];
		names = new String[startrobots];
		
		
		setColors(Color.red, Color.black, Color.yellow, Color.green, Color.blue);	//body, gun, radar, bullet, scan

		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		
		// Robot main loop
		out.println("field height: " + getBattleFieldHeight() + "\nfield width: " + getBattleFieldWidth());

//		turnRadarRightRadians(Double.POSITIVE_INFINITY);
		while(true) {
			
			turnRadarRightRadians(2*Math.PI);
//			turnRadarRightRadians(Math.PI/-4);
			//out.println("\n"+getRadarHeadingRadians());
		}
	}

	
	public void scancontrol(){
		
	}
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e ) {
		// Replace the next line with any behavior you would like
        
        
        
        if (target==e.getName()) {
        	double absBearing = e.getBearingRadians() + getHeadingRadians();
        	setTurnGunRightRadians(
        	    Utils.normalRelativeAngle(absBearing - 
        	    getGunHeadingRadians())
        	    );
        	fire(1);
        } else if (target=="NULLNULLNULL" ) {
        	target=e.getName();
        }
        
		out.println("\ntarget "+target+
					"\nmy change "+
					"\nmy radar "+getRadarHeadingRadians());
		
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		
	}	
	
	public void onRobotDeath(RobotDeathEvent e) {
		
		if (target==e.getName()){
			target="NULLNULLNULL";
		}
	}
	
}
