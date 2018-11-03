package eg.edu.alexu.csd.oop.calculator.cs24;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Nav {

	@FXML
	public Label history;

	@FXML
	public Label current;

	@FXML
	public ListView<String> view;

	@FXML
	public Label op1;

	@FXML
	public Label op2;

	@FXML
	public Label op3;

	@FXML
	public Label op4;

	@FXML
	public Label op5;

	Main main = new Main();
	MyCalc calculator = new MyCalc();
	LinkedList<String> list = new LinkedList<String>();
	int curr;

	@FXML
	public void history(ActionEvent event) {
		history();
		switch (curr) {
		case 0:
			op1.setText(list.get(0));
			break;
		case 1:
			op1.setText(list.get(0));
			op2.setText(list.get(1));
			break;
		case 2:
			op1.setText(list.get(0));
			op2.setText(list.get(1));
			op3.setText(list.get(2));
			break;
		case 3:
			op1.setText(list.get(0));
			op2.setText(list.get(1));
			op3.setText(list.get(2));
			op4.setText(list.get(3));
			break;
		case 4:
			op1.setText(list.get(0));
			op2.setText(list.get(1));
			op3.setText(list.get(2));
			op4.setText(list.get(3));
			op5.setText(list.get(4));
			break;

		}
	}

	@FXML
	public void current(ActionEvent event) {
		history();
		current.setText(list.get(curr));
	}

	@FXML
	public void prev(ActionEvent event) {
		current.setText(calculator.prev());
	}

	@FXML
	public void next(ActionEvent event) {
		current.setText(calculator.next());
	}

	@FXML
	public void save(ActionEvent event) {
		calculator.save();
	}

	@FXML
	public void load(ActionEvent event) {
		calculator.load();
	}

	public void history() {
		// TODO Auto-generated method stub
		File file = new File("history.txt");
		list.clear();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String verify = br.readLine();
			curr = Integer.parseInt(verify);
			for (; (verify = br.readLine()) != null;) {
				list.add(verify);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
