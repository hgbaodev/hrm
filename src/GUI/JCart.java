package GUI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class JCart extends JPanel{
	private Color colorTop;
	private Color colorBottom;
	public JCart() {
		colorTop = Color.white;
		colorBottom = Color.white;
		setOpaque(false);
	}
	public JCart(Color colorTop,Color colorBottom) {
		this.colorTop = colorTop;
		this.colorBottom = colorBottom;
		setOpaque(false);
	}
	
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint g = new GradientPaint(0, 0, colorTop, 0, getHeight(), colorBottom);
        g2.setPaint(g);
//        g2.setPaint(this.color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        

        super.paintComponent(grphcs);
    }
}
