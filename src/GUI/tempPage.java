package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class tempPage extends JPanel{
	private String text;
	public tempPage(String text) {
		this.text = text;
		init();
	}
	public void init() {
		this.setLayout(null);
		this.setBackground(new Color(255,255,255));
		JLabel lblabout = new JLabel(text);
		lblabout.setBounds(500,190,200,200);
		lblabout.setFont(new Font("Arial", Font.PLAIN, 30));
		this.add(lblabout);
	}
}
