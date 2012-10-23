package cookieCo;
//import java.awt.Color;

import robocode.AdvancedRobot;
//import robocode.HitByBulletEvent;
import robocode.RobotDeathEvent;
import robocode.ScannedRobotEvent;
//import java.awt.Color;
import robocode.util.Utils;


public class SadCookie extends AdvancedRobot
{
	
	String target="NULLNULLNULL";
	double targetdist=99999;
	
	public void run() {

		//setColors(Color.red, Color.black, Color.yellow, Color.green, Color.blue);	//body, gun, radar, bullet, scan
		
//		setAdjustRadarForRobotTurn(true);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		
		
		
		while(true) {
			setTurnRight(60);
			ahead(100);
//			setTurnLeft(120);
//			ahead(100);	
			setTurnRadarRightRadians(Math.PI*2);
		}
	}

	
//	public void move() {
//		ahead(100);
//		ahead(-100);
//			
//	}
	
	public void onScannedRobot(ScannedRobotEvent e) {
		

		//out.println("distance "  +e.getDistance());
		
		if (target==e.getName()) {
			targetdist=e.getDistance();
			
//			double radarTurn = getHeadingRadians() + e.getBearingRadians()- getRadarHeadingRadians();
//			       			       
//			setTurnRadarRightRadians(1*Utils.normalRelativeAngle(radarTurn));
//			
        	double absBearing = e.getBearingRadians() + getHeadingRadians();
        	setTurnGunRightRadians(
        	    Utils.normalRelativeAngle(absBearing - 
        	    getGunHeadingRadians())
        	    );

			setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
			
//        	double firepower=Math.min(Math.max(10*getEnergy()/e.getDistance(), 0.1),3);
        	fire(Math.min(Math.max(10*getEnergy()/e.getDistance(), 0.1),3));
//			fire(Math.min(Math.max(400/e.getDistance(), 0.1),3));
//        	out.println("power "+ firepower);
		} else if (e.getDistance()<targetdist) {
			target=e.getName();
			}
//         else if (target=="NULLNULLNULL" ) {
//        	target=e.getName();
//        }
		
	}
	
//	public void onHitByBullet(HitByBulletEvent e) {
////		int direction=1;
//		double absBearing = e.getBearingRadians() + getHeadingRadians();
//		setTurnRightRadians(
//        	    Utils.normalRelativeAngle((Math.PI/2)+absBearing - 
//        	    getHeadingRadians())
//        	    );
////		ahead(100*direction);
////		direction*=-1;
//	}
	
	
	public void onRobotDeath(RobotDeathEvent e) {
		
		if (target==e.getName()){
			targetdist=99999;
		}
	}


}
								