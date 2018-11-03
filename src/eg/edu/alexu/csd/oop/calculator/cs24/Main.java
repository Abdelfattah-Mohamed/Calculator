package eg.edu.alexu.csd.oop.calculator.cs24;

import java.util.LinkedList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static BorderPane root = new BorderPane();

	public static BorderPane getRoot() {
		return root;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent rootFX = FXMLLoader.load(getClass().getResource("Main_Controller.fxml"));
			Parent rootNav = FXMLLoader.load(getClass().getResource("Nav.fxml"));
			root.setCenter(rootFX);
			root.setRight(rootNav);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	MyCalc calulator = new MyCalc();

	public String current() {
		return calulator.current();
	}

	public String prev() {
		return calulator.prev();
	}

	public String next() {
		return calulator.next();
	}

	LinkedList<String> list = new LinkedList<String>();

	public LinkedList<String> history() {
		return MyCalc.list;
	}
}
