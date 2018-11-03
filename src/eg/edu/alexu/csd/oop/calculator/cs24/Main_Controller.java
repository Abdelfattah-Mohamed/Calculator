package eg.edu.alexu.csd.oop.calculator.cs24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Main_Controller {

	@FXML
	public TextField input;

	@FXML
	public Label result;

	boolean startI = true;
	boolean startR = true;

	MyCalc calculator = new MyCalc();

	@FXML
	public void set_operation(ActionEvent event) {
		if (startI) {
			input.clear();
			startI = false;
		}
		String value = ((Button) event.getSource()).getText();
		input.setText(input.getText() + value);
	}

	@FXML
	public void result(ActionEvent event) {
		if (startR) {
			result.setText("");
			startR = false;
		}
		String value = input.getText();
		calculator.input(value);
		result.setText(calculator.getResult());
		startI = true;
	}

	@FXML
	public void input(ActionEvent event) {
		String value = input.getText();
		calculator.input(value);
	}

}
