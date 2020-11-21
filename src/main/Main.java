package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.controllers.MainLayoutController;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	// * JAVAFX Boilerplate
	@Override
	public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/MainLayout.fxml"));
//        Group rootTemp = FXMLLoader.load(getClass().getResource("../resources/fxml/sample.fxml"));
		// Add circle object
//        Group root = new Group();
//        Circle myCircle = new Circle(new Point(100,100), 30);
		//Triangle myTriangle = new Triangle(new Point(100,100), 120);
//        LineObstacle line = new LineObstacle(new Point(0,100), 500);
//        Button button = new Button("Show Circle");
//        Button button2 = new Button("Rotate Circle");
//        button.setOnMouseClicked(e -> line.render(root));
//        button2.setOnMouseClicked(e -> line.play());
//        button.setLayoutX(200);button.setLayoutY(200);
//        button2.setLayoutX(300);button2.setLayoutY(100);
//        root.getChildren().addAll(line.getLineRoot().getChildren());
//        root.getChildren().add(button2);
//        root.getChildren().add(button);
//        root.getChildren().add(line.getLineRoot());
//        AnchorPane root = new AnchorPane();
//        MainLayoutController mainLayoutController = new MainLayoutController();
//        root.getChildren().add(mainLayoutController);
//        primaryStage.setTitle("Hello World");
//        Scene scene = new Scene(new MainLayoutController());
//        primaryStage.setTitle("Here are Tico and Teco!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/MainLayout.fxml"));
		MainLayoutController mainLayoutController = new MainLayoutController();
		primaryStage.setScene(new Scene(mainLayoutController));
		primaryStage.show();
//        mainLayoutController.setStage(2);
		//myTriangle.rotate();
	}
	//
}