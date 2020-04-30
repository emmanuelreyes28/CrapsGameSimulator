/*
 * Lab section 1
 * Vinh Lam (SID# 76785563)
 * Emmanuel Reyes (SID# 58725927)
 */

public class CrapsMetricsMonitor {
	/*
	 * This class handles the statics for each game simulation
	 * Has default class fields representing different variable that
	 * 	need to be tracked
	 * Has increment methods to increase the counts for games played, games won,
	 * 	games lost, natural count, and craps count.
	 * Has setter methods that set all the fields that are counting for maximums
	 * Has getter methods that set all the fields that are counting for maximums,
	 * 	as well as a getter method for getting the current number of games played
	 * Has a printStatistics methods to print all the statistics (use at the end
	 * 	of every simulation)
	 * Has a reset method that set all the class field to the default value (i.e. 0)
	 */
	
	
	//Default class fields
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int maxRoll; 
	private int naturalCount;
	private int crapsCount;
	private int maxWinStreak; 
	private int maxLoseStreak;  
	private int maxBalance;  
	private int maxBalanceGame; 
	
	//Increment methods
	public void incrGamesPlayed() {
		this.gamesPlayed++;
	}
	public void incrGamesWon() {
		this.gamesWon++;
	}
	public void incrGamesLost() {
		this.gamesLost++;
	}
	public void incrNaturalCount() {
		this.naturalCount++;
	}
	public void incrCrapsCount() {
		this.crapsCount++;
	}
	
	//Setter Methods
	public void setMaxRoll(int maxRoll) {
		this.maxRoll = maxRoll;
	}
	public void setMaxWinStreak(int maxWinStreak) {
		this.maxWinStreak = maxWinStreak;
	}
	public void setMaxLoseStreak(int maxLoseStreak) {
		this.maxLoseStreak = maxLoseStreak;
	}
	public void setMaxBalance(int maxBalance) {
		this.maxBalance = maxBalance;
	}
	public void setMaxBalanceGame(int maxBalanceGame) {
		this.maxBalanceGame = maxBalanceGame;
	}
	
	//Getter methods
	public int getGamesPlayed(){
		return gamesPlayed;
	}
	public int getMaxRoll() {
		return maxRoll;
	}
	public int getMaxWinStreak() {
		return maxWinStreak;
	}
	public int getMaxLoseStreak() {
		return maxLoseStreak;
	}
	public int getMaxBalance() {
		return maxBalance;
	}
	public int getMaxBalanceGame() {
		return maxBalanceGame;
	}
	
	//Method to print the statistics of games played
	public void printStatistics(){
		String stats ="*****************************\n*** SIMULATION STATISTICS ***\n*****************************\n";
		stats = stats + "Games played: " + gamesPlayed + "\n"+
						"Games won: " + gamesWon + "\n"+
						"Games lost: " + gamesLost + "\n"+
						"Maximun Rolls in a single game: " + maxRoll + "\n"+
						"Natural Count: " + naturalCount + "\n"+
						"Craps Count: " + crapsCount + "\n"+
						"Maximum Winning Streak: " + maxWinStreak + "\n"+
						"Maximum Loosing Streak: " + maxLoseStreak + "\n"+
						"Maximum balance: " + maxBalance + " during game " + maxBalanceGame;
		System.out.println(stats);
	}
	
	//Method to set all counters to 0
	public void reset(){
		gamesPlayed=gamesWon=gamesLost=maxRoll=naturalCount=crapsCount=maxWinStreak=maxLoseStreak=maxBalance=maxBalanceGame=0;
	}
}
