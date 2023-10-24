package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelCirCle extends JPanel{
	private Color color;
	public PanelCirCle(Color color) {
		this.color = color;
		setOpaque(false);
	}
	public PanelCirCle() {
		this.color = Color.black;
		setOpaque(false);
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		g2.drawOval(0, 0, getWidth(), getHeight());
		g2.fillOval(0, 0, getWidth(), getHeight());	
		
		super.paintComponent(g);
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
