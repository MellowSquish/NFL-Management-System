/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 */
import java.io.Serializable;

/* class Coach implements Serializable, creates coach object and returns a formatted string */
public class Coach implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Variables
	private String name;
	private int yearsOfExperience;
	
	/* Constructor to make coach object */
	Coach(String name, int yearsOfExperience){
		this.name = name;
		this.yearsOfExperience = yearsOfExperience;
	}
	
	/* Overrides formatted toString method */
	@Override
	public String toString() {
		return String.format("%-14s(%d years)", name, yearsOfExperience);
	}
}
