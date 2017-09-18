package project4;

import javax.swing.*;

public class View {

private JFrame frame;

public View() {
	frame = new JFrame();
	mainView();
}

private void mainView() {
	frame.setBounds(100,100,500,500);
	frame.setLayout(null);
	
	
	
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}
}
