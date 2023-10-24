package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class myNotification extends JPanel{
	private Color color;
	private int number;
	private Font font;
	public myNotification() {
		
		color = Color.red;
		font = new Font("sansserif", 1, 10);
		setOpaque(false);
	}
	public myNotification(Color color, int number) {
		this.color =color;
		this.number = number;
		 setOpaque(false);
		 this.setLayout(new BorderLayout());
		 JLabel lbnumber = new JLabel(number+"",JLabel.CENTER);
		 lbnumber.setForeground(Color.white);
		 lbnumber.setFont(font);
		 this.add(lbnumber,BorderLayout.CENTER);
	}
	public myNotification(Color color, int number,Font font) {
		
		this.font = font;
		this.color =color;
		this.number = number;
		 setOpaque(false);
		 this.setLayout(new BorderLayout());
		 JLabel lbnumber = new JLabel(number+"",JLabel.CENTER);
		 lbnumber.setForeground(Color.white);
		 lbnumber.setFont(font);
		 this.add(lbnumber,BorderLayout.CENTER);
		
	}
	protected void paintComponent(Graphics grphcs) {
	     Graphics2D g2 = (Graphics2D) grphcs;
	     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	     g2.setPaint(color);
	     g2.fillOval(0,0, getWidth(), getHeight());
	     super.paintComponent(g2);
	}
	public void setNumber(int number) {
		this.setLayout(new BorderLayout());
		JLabel lbnumber = new JLabel(number+"",JLabel.CENTER);
		lbnumber.setFont(font);
		lbnumber.setForeground(Color.white);
		this.add(lbnumber,BorderLayout.CENTER);
	}
}
