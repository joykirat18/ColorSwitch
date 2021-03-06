package main.gui.obstacles;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import main.Constants;
import main.gui.PlayerBall;
import main.gui.Point;

import java.util.Arrays;

public class LineObstacle extends Obstacle {

	public static final long serialVersionUID = 6;
	private final double sceneLength;
	transient private TranslateTransition translateTransitions;
	transient private Line[] lineList;

	public LineObstacle(Point start, double sceneLength, Boolean positiveDirection) {
		double length = sceneLength / Constants.COLOUR_PALETTE.length;
		this.setPosition(start);
		if (!positiveDirection) {
			this.setPosX(sceneLength - this.getPosX());
		}
		this.sceneLength = sceneLength;
		this.lineList = new Line[2 * Constants.COLOUR_PALETTE.length];
		this.obstacleRoot = new Group();
		int noOfSegments = Constants.COLOUR_PALETTE.length;
//		this.translateTransitions = new TranslateTransition[2 * Constants.COLOUR_PALETTE.length];
		for (int i = noOfSegments - 1; i >= 0; i--) {
			this.lineList[i] = new Line();
			setCoordinateOfLine(this.lineList[i], this.getPosX() + (i - noOfSegments + 1) * length, this.getPosY(), this.getPosX() + (i - noOfSegments) * length, this.getPosY());
			this.lineList[i].setStroke(Constants.COLOUR_PALETTE[i]);
			this.lineList[i].setStrokeWidth(this.strokeWidth);
		}
		for (int i = noOfSegments; i < 2 * noOfSegments; i++) {
			this.lineList[i] = new Line();
			setCoordinateOfLine(this.lineList[i], this.getPosX() + (i - noOfSegments) * length, this.getPosY(), this.getPosX() + (i - noOfSegments + 1) * length, this.getPosY());
			this.lineList[i].setStroke(Constants.COLOUR_PALETTE[i - noOfSegments]);
			this.lineList[i].setStrokeWidth(this.strokeWidth);
		}
		this.translateTransitions = new TranslateTransition();
		if (positiveDirection) {
			this.translateTransitions.setByX(sceneLength);
		} else {
			this.translateTransitions.setByX(-sceneLength);
		}
		this.translateTransitions.setDuration(Duration.millis(10000));
		this.translateTransitions.setInterpolator(Interpolator.LINEAR);
		this.translateTransitions.setCycleCount(500);
		this.translateTransitions.setNode(this.obstacleRoot);

	}

	public void setCoordinateOfLine(Line line, double startX, double startY, double endX, double endY) {
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);
	}

	public void render(Group root) {

		if (this.obstacleRoot.getChildren().containsAll(Arrays.asList(this.lineList))) {
			this.obstacleRoot.getChildren().removeAll(this.lineList);
			root.getChildren().removeAll(this.obstacleRoot);
		} else {
			this.obstacleRoot.getChildren().addAll(this.lineList);
			root.getChildren().addAll(this.obstacleRoot);
		}
	}

	public void play() {
//		for (int i = 0; i < this.lineList.length; i++) {
		if (translateTransitions.getStatus() == Animation.Status.PAUSED || translateTransitions.getStatus() == Animation.Status.STOPPED) {
			this.translateTransitions.play();
		} else {
			this.translateTransitions.pause();
		}
//		}
	}


	public double getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(double strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	@Override
	public boolean isCollision(PlayerBall ball) {
		boolean collisionDetected = false;

		for (int i = 0; i < lineList.length; i++) {
			Shape intersect = Shape.intersect(lineList[i], ball.getBallRoot());
			if (lineList[i].getStroke() != ball.getBallRoot().getFill()) {
				if (intersect.getBoundsInLocal().getWidth() != -1) {
					collisionDetected = true;
				}
			}
		}
		if (collisionDetected) {
//			System.out.println("Collision Detected");
		}
		return collisionDetected;
	}

	@Override
	public void setPosition() {
		Point point = new Point(0, this.obstacleRoot.getTranslateY() + this.obstacleRoot.getLayoutY() + this.getPosY());
		this.setPosition(point);
	}

	@Override
	public void init() {
		// TODO This might be messed up, I do not know the general start point.
		double length = this.sceneLength / Constants.COLOUR_PALETTE.length;
		if (!positiveDirection) {
			this.setPosX(this.sceneLength - this.getPosX());
		}
		System.out.println("Line Obstacle @ " + this.getPosition());
		this.lineList = new Line[2 * Constants.COLOUR_PALETTE.length];
		this.obstacleRoot = new Group();
		int noOfSegments = Constants.COLOUR_PALETTE.length;

		for (int i = noOfSegments - 1; i >= 0; i--) {
			this.lineList[i] = new Line();
			setCoordinateOfLine(this.lineList[i], this.getPosX() + (i - noOfSegments + 1) * length, this.getPosY(), this.getPosX() + (i - noOfSegments) * length, this.getPosY());
			this.lineList[i].setStroke(Constants.COLOUR_PALETTE[i]);
			this.lineList[i].setStrokeWidth(this.strokeWidth);
		}
		for (int i = noOfSegments; i < 2 * noOfSegments; i++) {
			this.lineList[i] = new Line();
			setCoordinateOfLine(this.lineList[i], this.getPosX() + (i - noOfSegments) * length, this.getPosY(), this.getPosX() + (i - noOfSegments + 1) * length, this.getPosY());
			this.lineList[i].setStroke(Constants.COLOUR_PALETTE[i - noOfSegments]);
			this.lineList[i].setStrokeWidth(this.strokeWidth);
		}
		this.translateTransitions = new TranslateTransition();
		if (positiveDirection) {
			this.translateTransitions.setByX(this.sceneLength);
		} else {
			this.translateTransitions.setByX(-this.sceneLength);
		}
		this.translateTransitions.setDuration(Duration.millis(10000));
		this.translateTransitions.setInterpolator(Interpolator.LINEAR);
		this.translateTransitions.setCycleCount(500);
		this.translateTransitions.setNode(this.obstacleRoot);


	}
}