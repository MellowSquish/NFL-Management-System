/* 
 * Student Name: Chloe Capriotti
 * Student Number: 041154964
 * Course: CST8132_310 OOP
 * Lab Professor: James Mwangi PhD
 * 
 */ 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

/* Team manager loads team information displays a team, adds a teams, finds a team based on user input */
public class TeamManager{
	private ArrayList<Team> teams = new ArrayList<>();
	
	
	public List<Team> getTeams(){
		return teams;
	}//getTeams
	
	
	/* Loads team information from csv file */
	public void loadTeamsFromFile(String filename) {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
            	
            	//splits data by each ,
                String[] data = line.split(",");
                
                //matches data to a part of data
                if (data.length >= 4) {
                 String teamName = data[0].trim();
                    String city = data[1].trim();
                    String coachName = data[2].trim();
                    int yearsOfExperience = Integer.parseInt(data[3].trim());
                    
                    //references coach object and players array(to get the number of players for team)
                    Coach coach = new Coach(coachName, yearsOfExperience);
                    List<Player> players = new ArrayList<>();
                    
                    //Create team object
                    Team team = new Team(teamName, city, coach, players);
                    
                    //add team to team list
                    teams.add(team);
            }//if 
    }} catch (IOException e) {
            e.printStackTrace();
        }//catch
    }//loadTeamsFromFile

	
    /* Method to display all teams */
    public void displayTeams() { 
    	for (Team t : teams) { 
    		System.out.println(t.toString());
    	}//for loop
    	
    }//displayTeams
    
    
	/* Adds a team to the team collection */
	public void addTeam(String teamName, String city, String coachName, int yearsOfExperience) {
		Coach coach = new Coach(coachName, yearsOfExperience);
		List<Player> players = new ArrayList<>();
		Team team = new Team(teamName, city, coach, players);
		teams.add(team);
	}//addTeam
	
	
	/* finds a team from the team collection from user input */
	public Team findTeam(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
		return team;
            }//if	
        } return null; 
    }//findTeam
}//TeamManager Class
