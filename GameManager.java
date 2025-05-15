
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
import java.util.ArrayList;

/* Game manager method, loads games from files and displays them with the displayGames method  */
public class GameManager {
	private ArrayList<Game> games = new ArrayList<>();

	/* loadGamesFromFile method loads game information from csv file and formats it */
	public void loadGamesFromFile(String filename) {
		String line;

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while ((line = br.readLine()) != null) {

				// splits data by each ,
				String[] data = line.split(",");

				// matches data to a part of data
				if (data.length >= 5) {
					String team1 = data[0].trim();
					String team2 = data[1].trim();
					String date = data[2].trim();
					String location = data[3].trim();
					String score = data[4].trim();

					// Creates game object
					Game game = new Game(team1, team2, date, location, score);

					// adds game to game list
					games.add(game);
				} // if loop
			}
		} catch (IOException e) {
			e.printStackTrace();
		} // catch
	}// loadGamesFromFile method

	/* displays formatted game information */
	public void displayGames() {
		for (Game g : games) {
			System.out.println(g.toString());
		} // for loop
	}// displayGames method
}// GameManager class
