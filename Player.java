/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 */
import java.io.Serializable;
 /* Player class implements Serializable and creates a Player object, gets player information, and returns a formatted string */
public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Variables
	private String playerId;
	private String name;
	private int age;
	private String teamName;
	private String position;
	
	/* Constructor to make Player object */
	public Player(String playerId, String name, int age, String teamName, String position){
		this.playerId = playerId;
		this.name = name;
		this.age = age;
		this.teamName = teamName;
		this.position = position;
	}
	
	//Getters
	public String getPlayerId() {
		return playerId;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getTeamName() {
		return teamName;
	}
	public String getPosition() {
		return position;
	}
	
	/* Overrides formatted toString method */
	@Override
	public String toString(){
		return String.format("%-5s %-18s %-5d %-10s %-15s%n", playerId, name, age, teamName, position);
	}
}
