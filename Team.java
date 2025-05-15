/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 * 
 */
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/* Team class implements Serializable, creates a Team object, has the addPlayer method, getter for player collection and returns a formatted string */
public class Team implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Variables
	public String teamName;
	private String city;
	private Coach coach;
	private List<Player> players;
	
	/* Constructor to make team object */
	Team(String teamName, String city, Coach coach, List<Player> players){
		this.teamName = teamName;
		this.city = city;
		this.coach = coach;
		this.players = players == null ? new ArrayList<>() : players;
	}
	
	//getters
	public String getTeamName() {
		return teamName;
	}
	public String getCity() {
		return city;
	}
	public Coach getCoach() {
		return coach;
	}
	/* gets list of players from player collection */
	public List<Player> getPlayers() {
		return players;
	}
	
	/* adds players to player collection */
	public void addPlayer(Player player){
			players.add(player);
	}
	
	/* Overrides formatted toString method */
	@Override
	public String toString() {
		return String.format("%-10s %-15s %-30s %-5d%n", teamName, city, coach, players.size());
	}
}
