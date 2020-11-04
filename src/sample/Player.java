package sample;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
	private final String name = "user";
	private int highScore;
	private ArrayList<Game> savedGames;
	private int numberOfStars;
	// save the stats of the player after every game
	// private Game currentGame;

	public static void serialize() throws IOException {

	}

	public static void deserialize() throws IOException, ClassNotFoundException {

	}

	public String getName() {
		return name;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public ArrayList<Game> getSavedGames() {
		return savedGames;
	}

	public void setSavedGames(ArrayList<Game> savedGame) {
		this.savedGames = savedGame;
	}

	public int getNumberOfStars() {
		return numberOfStars;
	}

	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
	}

	public void addToSavedGames(Game currentGame) {
		this.savedGames.add(currentGame);
	}

}
