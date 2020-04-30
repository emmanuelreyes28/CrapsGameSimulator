/*
 * Lab section 1
 * Vinh Lam (SID# 76785563)
 * Emmanuel Reyes (SID# 58725927)
 */

import java.util.Random;

public class CrapsGame {
	/*
	 * This class handles the actions including game-play, and
	 * 	updating some of the fields in the CrapsMetricsMonitor object
	 * Has a constructor that takes a CrapsMetricsMonitor object in order
	 * 	to update the statistics
	 * Has a timesRoll field to keep track of the number of time the dices
	 * 	rolled per game
	 * Has a playGame method that handles game-play for one entire game of Craps
	 */
	
	//default class fields
	private int timesRoll;
	private CrapsMetricsMonitor monitor;
	
	//Constructor that takes a CrapsMetricsMonitor object
	public CrapsGame(CrapsMetricsMonitor monitor){
		this.monitor = monitor;
	}
	
	//Getter methods
	public int getTimesRoll(){
		return timesRoll;
	}
	
	public boolean playGame(){
		/*represent the game play for 1 single game
		 * return true for win
		 * and false for lost 
		*/
		timesRoll = 0;
		Random rand = new Random();
		int rolled = rand.nextInt(6)+1 + rand.nextInt(6)+1;
		System.out.println("Rolled a " + rolled);
		timesRoll++;
		if(rolled==7 || rolled==11){
			System.out.println("*****Natural! You win!*****");
			monitor.incrNaturalCount();
			return true;
		}else if(rolled==2 || rolled==3 || rolled==12){
			System.out.println("*****Crap out! You loose.*****");
			monitor.incrCrapsCount();
			return false;
		}else{
			int point = rolled;
			while(true){
				rolled = rand.nextInt(6)+1 + rand.nextInt(6)+1;
				System.out.println("Rolled a " + rolled);
				timesRoll++;
				if(rolled == point){
					System.out.println("*****Rolled the point! You win!*****");
					return true;
				}else if(rolled == 7){
					System.out.println("*****Crap out! You loose.*****");
					return false;
				}else{}
			}
		}
	}
}
