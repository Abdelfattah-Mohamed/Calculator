package eg.edu.alexu.csd.oop.calculator.cs24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import eg.edu.alexu.csd.oop.calculator.Calculator;

public class MyCalc implements Calculator {

	public double n1 = 0;
	public double n2 = 0;
	public char operation;
	public static LinkedList<String> list = new LinkedList<String>();
	public static int current = -1;
	boolean flag = false;

	@Override
	public void input(String s) {
		// TODO Auto-generated method stub
		String str = "";
		str += s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || s.charAt(i) == '*') {
				if ((s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-' || s.charAt(i - 1) == '/'
						|| s.charAt(i - 1) == '*')) {
					str += s.charAt(i);
				} else {
					operation = s.charAt(i);
					n1 = Double.parseDouble(str);
					str = "";
				}
			} else {
				str += s.charAt(i);
			}

		}
		n2 = Double.parseDouble(str);
		if (!flag) {
			list.add(s);

			if (current < list.size()) {
				current = list.size() - 1;
			} else {
				current++;
			}

			if (list.size() > 5) {
				list.removeFirst();
				current--;
			}
		}
		history();
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		flag = true;
		input(list.get(current));
		flag = false;
		switch (operation) {
		case '+':
			return Double.toString(n1 + n2);
		case '-':
			return Double.toString(n1 - n2);
		case '*':
			return Double.toString(n1 * n2);
		case '/':
			if (n2 != 0) {
				return Double.toString(n1 / n2);
			}
		}
		return null;
	}

	@Override
	public String current() {
		// TODO Auto-generated method stub
		if (current == -1) {
			return null;
		}
		return list.get(current);
	}

	@Override
	public String prev() {
		// TODO Auto-generated method stub

		if (current <= 0) {
			return null;
		}
		current--;
		return list.get(current);
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub

		if (current >= list.size() - 1) {
			return null;
		}
		current++;
		return list.get(current);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		File file = new File("save.txt");
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Integer.toString(current));
			bw.newLine();
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		File file = new File("save.txt");
		list.clear();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String verify = br.readLine();
			current = Integer.parseInt(verify);
			for (; (verify = br.readLine()) != null;) {
				list.add(verify);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void history() {
		// TODO Auto-generated method stub
		File file = new File("history.txt");
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Integer.toString(current));
			bw.newLine();
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
