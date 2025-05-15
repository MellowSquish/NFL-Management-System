/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 * 
 */ 
import java.util.Scanner;

/* holds main method, takes user input based on menu choice input, calls methods from manager classes */
public class NFLOperationsManagementSystem {
	
	/* Prints a menu */
	public static void ShowMenu(){
		System.out.println("NFL Operations Management System\n" 
				 		 + "1. Display Teams\n"
					     + "2. Display Players\n"
					     + "3. Display Scheduled Games\n"
					     + "4. Add Team\n"
					     + "5. Add Player to Team\n"
					     + "6. Find Team\n"
					     + "7. Exit");
    }//ShowMenu
	/* main method */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TeamManager teamManager = new TeamManager();
		PlayerManager playerManager = new PlayerManager();
		GameManager gameManager = new GameManager();
		
		//Loading data
		teamManager.loadTeamsFromFile("teams.csv");
		playerManager.loadPlayersFromFile("players.csv", teamManager);
		gameManager.loadGamesFromFile("games.csv");
		
		int menuChoice;
		while(true) {
			ShowMenu();
			System.out.print("Enter Choice: ");
	
			if (!scanner.hasNextInt()) {
				System.out.println("***Invalid choice. Try again***");
				scanner.next();
				continue;
			}//if
			String divider = "--------------------------------------------------------------------";
			menuChoice = scanner.nextInt();
			scanner.nextLine();
			switch (menuChoice) {
				//Display Teams
				case 1:
					System.out.println(divider);
					System.out.printf("%-10s %-15s %-30s %-7s%n", "Team", "City", "Coach", "Players");
				    System.out.println(divider);
					
					teamManager.displayTeams();
					break;
				//display players
				case 2:
					System.out.println(divider);
					System.out.printf("%-5s %-18s %-5s %-10s %-15s%n", "ID", "Name", "Age", "Team", "Position");
					System.out.println(divider);
				    
					playerManager.displayPlayers();
					break;
				//display the scheduled games
				case 3:
					System.out.println(divider);
					System.out.printf("%-10s %-10s %-12s %-15s %-5s%n", "Home", "Visitor", "Date", "Location", "Score");
				    System.out.println(divider);
					
					gameManager.displayGames();
					break;
				//add a team
				case 4:
					System.out.println("Enter team name: ");
					String teamName = scanner.nextLine();
					
					System.out.println("Enter city: ");
					String city = scanner.nextLine();
					
					System.out.println("Enter coach name: ");
					String coachName = scanner.nextLine();
					
					System.out.println("Enter coach years of experience: ");
					if (!scanner.hasNextInt()) {
					    System.out.println("*** Invalid Character, Enter an Integer ***");
					    scanner.next();
					    continue;
					}else{
					    int yearsOfExperience = Integer.parseInt(scanner.nextLine());
					    teamManager.addTeam(teamName, city, coachName, yearsOfExperience);
					    System.out.println("Team added successfully!");
					    break;
					}//if
				//add a player to a team
				case 5:
					System.out.println("Enter player ID: ");
					String playerId = scanner.nextLine();
					
					System.out.println("Enter player name: ");
					String name = scanner.nextLine();
					
					System.out.println("Enter player age: ");
					if (!scanner.hasNextInt()) {
						System.out.println("*** Invalid Character, Enter an Integer ***");
						scanner.next();
						continue;
					} else {
						int age = Integer.parseInt(scanner.nextLine());
						System.out.println("Enter team name: ");
						teamName = scanner.nextLine();
						
						System.out.println("Enter player position: ");
						String position = scanner.nextLine();
						
						playerManager.addPlayer(playerId, name, age, teamName, position, teamManager);
						System.out.println("Player added successfully!");
						break;
					}
				//find a team
				case 6:
					System.out.println("Enter team name to search: ");
					teamName = scanner.nextLine();
					Team team = teamManager.findTeam(teamName);
					if (team == null) {
						System.out.println("Team not found");
						continue;
					} else {
					System.out.println("Team found: " + team);
					break;
					}
				//Exit the program
				case 7:
					System.out.println("                                                      \n"
							         + "******************************************************\n"
							         + "     ...Exiting the program by Chloe Capriotti...     \n"
							         + "                                                      \n"
									 + "******************************************************");

					System.out.println("The Serializable interface enables a class to have its state saved \n"
							+ "(serialised) and restored (deserialised); in this program it would save objects which \n."
							+ "can be saved to files or transfered over a network");
					System.out.println();
					System.out.println("I didn't use the coach.csv due to all the information needed in that file \n"
							+ "already exists in teams.csv and ca be collected from teams");
					
					scanner.close();
					return;
				//Any input other than 1-7
				default:
					System.out.println("***Invalid choice. Try again***");
				}//switch 
			}//while
		}//main
	}//NFLOperationsManagementSystem Class
