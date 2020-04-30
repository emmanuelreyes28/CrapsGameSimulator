/*
 * Lab section 1
 * Vinh Lam (SID# 76785563)
 * Emmanuel Reyes (SID# 58725927)
 */

import java.util.Scanner;

public class CrapsSimulation {
	/*
	 * This class handles the entire simulation of the craps game.
	 * 	Including:
	 * 		- Using CrapsGame object to play games until user's balance
	 * 		- reaches 0.
	 * 		- Requesting relevant inputs from the user.
	 *		- Updating and printing game statistics using
	 *		  CrapsMetricsMonitor object.
	 *		- Running multiple games simulation base on user input
	 *Has a default constructor to create default class fields
	 *Has a start method to run the entire simulation
	 */
	
	//default class fields
	private CrapsMetricsMonitor monitor = new CrapsMetricsMonitor();
	private CrapsGame game = new CrapsGame(monitor);
	private String username;
	private int userBalance;
	private int userBet;
	private int winStreak;
	private int loseStreak;
	private Scanner input = new Scanner(System.in);
	
	//Default constructor that takes no argument
	public CrapsSimulation(){}
	
	public void start(){
		/*
		 * Runs that entire game simulation including replaying games
		 */
		
		String replay = "y";
		while(replay.equals("y")){
			//Prompt the user for information before running the game
			System.out.print("Welcome to SimCraps! Enter your user name: ");
			username = input.nextLine();
			System.out.println("Hello " + username + "!");
			System.out.print("Enter the amount of money you will bring to the table: ");
			userBalance = input.nextInt();
			System.out.print("Enter the bet amount between $1 and $" + userBalance + ": ");
			userBet = input.nextInt();
			while (userBet<1 || userBet>userBalance){
				System.out.print("Invalid bet! Please enter a bet between $1 and $"+ userBalance + ": ");
				userBet = input.nextInt();
			}
			
			//Reset statistics games play 
			monitor.reset();
			
			//Set lowBetMode off (will set to on if user's bet amount
			//	is less than the current balance)
			//lowBet amount will be the player's current balance (less default
			//	than default bet amount)
			boolean lowBetMode = false;
			int lowBet=0;
			
			//Repeatedly run Craps games until user's balance reaches 0
			while (userBalance > 0){
				System.out.println(username + "'s balance: " + userBalance + ". Playing a new game...");
				if(lowBetMode==false){
					System.out.println(username + " bets $" + userBet);
				}else{
					System.out.println(username + " bets $" + lowBet);
				}
				//Set max balance and @specific game (for statistics)
				if(monitor.getMaxBalance() < userBalance){
					monitor.setMaxBalance(userBalance);
					monitor.setMaxBalanceGame(monitor.getGamesPlayed()+1);
				}
				
				if(game.playGame()==false){ //Handles lost
					if(lowBetMode){
						userBalance = userBalance - lowBet;
					}else{
						userBalance = userBalance - userBet;
					}
					//Update statistics -> lose streak, win steak, max lose streak,
					//	and #lose
					loseStreak++;
					winStreak = 0;
					if(monitor.getMaxLoseStreak() < loseStreak){
						monitor.setMaxLoseStreak(loseStreak);
					}
					monitor.incrGamesLost();
					
				}else{ //Handles win
					if(lowBetMode){
						userBalance = userBalance + lowBet;
					}else{
						userBalance = userBalance + userBet;
					}
					//Update statistics -> win steak, lose streak, max win streak,
					//	and #win
					winStreak++;
					loseStreak = 0;
					if(monitor.getMaxWinStreak() < winStreak){
						monitor.setMaxWinStreak(winStreak);
					}
					monitor.incrGamesWon();
				}
				//Checks user's balance and bet amount and
				//	set lowBetMode on/off depending if the user has
				//	enough money to bet
				if(userBalance < userBet){
					lowBet = userBalance;
					lowBetMode = true;
				}else{
					lowBetMode = false;
				}
				//update statistics -> max roll/game and #games played 
				if(monitor.getMaxRoll() < game.getTimesRoll()){
					monitor.setMaxRoll(game.getTimesRoll());
				}
				monitor.incrGamesPlayed();
			}
			
			//Prints the statistics of the simulation
			System.out.println();
			monitor.printStatistics();
			
			//Prompt user to run another simulation
			System.out.println();
			System.out.print("Replay? Enter 'y' or 'n': ");
			replay = input.next().toLowerCase();
			while(!replay.equals("y") && !replay.equals("n")){
				System.out.print("Invalid input! Please enter 'y' or 'n': ");
				replay = input.next().toLowerCase();
			}
			//Calling input.next will skip a line, adding a extra line
			//if user decides to replay
			input.nextLine();
		}
	}
}
