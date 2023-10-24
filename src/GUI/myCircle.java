package GUI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class myCircle extends JPanel{
	private Color colorTop;
	private Color colorBottom;
	public myCircle(Color colorTop,Color colorBottom) {
		this.colorTop = colorTop;
		this.colorBottom = colorBottom;
		setOpaque(false);
	}
	public void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		GradientPaint gp = new GradientPaint(0, 0,colorTop, getWidth(), getHeight(),colorBottom);
		g2.setPaint(gp);
		g2.drawOval(0, 0, getWidth(), getHeight());
		g2.fillOval(0, 0, getWidth(), getHeight());	
		super.paintComponent(grphcs);
	}
}
