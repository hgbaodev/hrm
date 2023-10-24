package GUI;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class JPanelOval extends JPanel{
	private Color color;
	private int oval;
	public JPanelOval() {
		oval = 15;
		color = Color.white;
		setOpaque(false);
	}
	protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setPaint(color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), oval, oval);
        g2.setColor(new Color(255, 255, 255, 50));
   
        super.paintComponent(grphcs);
    }
	public void setColor(Color color) {
		this.color = color;
	}
	public void setOval(int oval) {
		this.oval = oval;
	}
}
