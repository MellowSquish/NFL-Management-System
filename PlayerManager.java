/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/* loads the players from file and displays the information */
public class PlayerManager {
	private ArrayList<Player> players = new ArrayList<Player>();

	
	/* loads players from filename with BufferedReader */
	public void loadPlayersFromFile(String filename, TeamManager teamManager){	
		String line;

	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
            	
            	//splits data by each ,
                String[] data = line.split(",");
                
                //matches data to a part of data
                if (data.length >= 5) { 
                    String playerId = data[0].trim();
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String teamName = data[3].trim();
                    String position = data[4].trim();

                    // Create Player object
                    Player player = new Player(playerId, name, age, teamName, position);

                    // Add player to the players list
                    players.add(player);

                    // Find the corresponding team and add the player to it
                    for (Team team : teamManager.getTeams()) {
                        if (team.getTeamName().equalsIgnoreCase(teamName)) {
                            team.addPlayer(player);
                        }//if loop
                   }//for loop
            }//if loop
     }//while
     br.close();
     } catch (IOException e) {
    	 System.err.println("Error reading file: " + e.getMessage());
     }//catch
}//loadPlayers from file
	
	
	/* displays the player array */
	public void displayPlayers() {
		for (Player p : players) {
			System.out.println(p.toString());
	        }//for loop
	    }//displayPlayers

	
	/* adds a player to the player collection */
	public void addPlayer(String playerId,String name,int age,String teamName,String position, TeamManager teamManager) {
		Player player = new Player(playerId, name, age, teamName, position);
		players.add(player);
		teamManager.findTeam(teamName).addPlayer(player);
	}//addPlayer method
}//PlayerManager Class