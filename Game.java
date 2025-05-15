/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 */
import java.io.Serializable;

/* Game class implements Serializable and creates a game object, returns a formatted string */
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Variables
	private String team1;
	private String team2;
	private String date;
	private String location;
	private String score;
	
	/* Constructor to make game object */
	Game(String team1, String team2, String date, String location, String score){
		this.team1 = team1;
		this.team2 = team2;
		this.date = date;
		this.location = location;
		this.score = score;
	}
	
	/* Overrides formatted toString method */
	@Override
	public String toString(){
		return String.format("%-10s %-10s %-12s %-15s %-5s%n", team1, team2, date, location, score);
	}
}

