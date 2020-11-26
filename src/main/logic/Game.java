package main.logic;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.util.Duration;
import main.controllers.StartGameController;
import main.gui.ColourSwitchBall;
import main.gui.PlayerBall;
import main.gui.Point;
import main.gui.Star;
import main.gui.obstacles.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {

	private transient Player player;
	// Player Game 2 way association maybe recursion in serialization
	// When deserializing PLayer object, in savedGames() in a Game object
	// set Game.player = this to give reference of the player to Game object
	private ArrayList<Obstacle> listOfObstacles;
	private ArrayList<Star> listOfStar;
	private ArrayList<ColourSwitchBall> listOfSwitch;
	private PlayerBall playerBall;
	private int currentScore;
	private Group gameRoot;
	private StartGameController gameController;

	public Game(StartGameController gameController) {
		this.listOfStar = new ArrayList<>();
		this.listOfSwitch = new ArrayList<>();
		this.gameController = gameController;
		this.listOfObstacles = new ArrayList<>(6);
		this.gameRoot = new Group();
		this.playerBall = new PlayerBall(new Point(250, 600), this.gameController);
		ColourSwitchBall colourSwitchBall = new ColourSwitchBall(new Point(250, 270), 15);
		this.gameRoot.getChildren().add(colourSwitchBall.root);
		this.gameRoot.getChildren().add(playerBall.root);
		this.listOfObstacles.add(new LineObstacle(new Point(0, 100), 500, true));
		this.listOfObstacles.add(new LineObstacle(new Point(0, 130), 500, false));
		this.listOfObstacles.add( new PlusObstacle(new Point(200, 200), 50, true));
		this.listOfObstacles.add( new PlusObstacle(new Point(300, 200), 50, false));
		this.listOfObstacles.add( new RectangleObstacle(new Point(250, 400), 100, 100, false));
		this.listOfObstacles.add( new CircleObstacle(new Point(250, 400), 100, true));
		for (Obstacle obstacle : this.listOfObstacles) {
			obstacle.render(this.gameRoot);
			obstacle.play();
		}
	}

	public StartGameController getGameController() {
		return gameController;
	}

	public void setGameController(StartGameController gameController) {
		this.gameController = gameController;
	}

	public Group getGameRoot() {
		return gameRoot;
	}

	public void setGameRoot(Group gameRoot) {
		this.gameRoot = gameRoot;
	}

	public ArrayList<ColourSwitchBall> getListOfSwitch() {
		return listOfSwitch;
	}

	public void setListOfSwitch(ArrayList<ColourSwitchBall> listOfSwitch) {
		this.listOfSwitch = listOfSwitch;
	}

	public ArrayList<Star> getListOfStar() {
		return listOfStar;
	}

	public void setListOfStar(ArrayList<Star> listOfStar) {
		this.listOfStar = listOfStar;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Obstacle> getListOfObstacles() {
		return listOfObstacles;
	}

	public void setListOfObstacles(ArrayList<Obstacle> listOfObstacles) {
		this.listOfObstacles = listOfObstacles;
	}

	public PlayerBall getPlayerBall() {
		return playerBall;
	}

	public void setPlayerBall(PlayerBall playerBall) {
		this.playerBall = playerBall;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	/**
	 * Check collision of ball with any game element
	 */
	public void checkCollision() {

	}


	/**
	 * pause button click handles
	 */
	public void pauseGame() {

	}
	// pause button click handles

	/**
	 * serializes game for that player
	 */
	public void saveGame() {

	}
	// serializes game for that player

	public void resumeGame() {

	}

	public void startGame(){

	}

	public boolean isScrollRequired() {
		return (this.getPlayerBall().root.getTranslateY() < -300);
	}

	public void scrollScreen() {
		double lengthOfScroll = Math.abs(300 + this.playerBall.root.getTranslateY());
		for(Obstacle obstacle: listOfObstacles){
			TranslateTransition scrollDown = new TranslateTransition(Duration.millis(1000), obstacle.getObstacleRoot());
			scrollDown.setInterpolator(Interpolator.EASE_BOTH);
			scrollDown.setByY(lengthOfScroll);
			scrollDown.setCycleCount(1);
			scrollDown.play();
		}
		for(ColourSwitchBall colourSwitchBall : listOfSwitch){
			TranslateTransition scrollDown = new TranslateTransition(Duration.millis(1000), colourSwitchBall.root);
			scrollDown.setInterpolator(Interpolator.EASE_BOTH);
			scrollDown.setByY(lengthOfScroll);
			scrollDown.setCycleCount(1);
			scrollDown.play();
		}
		for(Star star: listOfStar){
			TranslateTransition scrollDown = new TranslateTransition(Duration.millis(1000), star.root);
			scrollDown.setInterpolator(Interpolator.EASE_BOTH);
			scrollDown.setByY(lengthOfScroll);
			scrollDown.setCycleCount(1);
			scrollDown.play();
		}
		TranslateTransition scrollDown = new TranslateTransition(Duration.millis(1000), this.playerBall.root);
		scrollDown.setInterpolator(Interpolator.EASE_BOTH);
		scrollDown.setByY(lengthOfScroll);
		scrollDown.setCycleCount(1);
		scrollDown.play();
//		playerBall
		System.out.println("Scroll");
	}
}
