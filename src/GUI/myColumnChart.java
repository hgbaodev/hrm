package GUI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class myColumnChart extends JPanel{
	private Color colorTop;
	private Color colorBottom;
	public myColumnChart(Color colorTop, Color colorBottom) {
		this.colorTop = colorTop;
		this.colorBottom = colorBottom;
	}
	protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gd = new GradientPaint(0, 0, colorTop, 0, getHeight(), colorBottom);
        g2.setPaint(gd);
        g2.fillRect(0 , 0, getWidth(), getHeight());
    }
}
