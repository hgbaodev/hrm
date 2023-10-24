package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.plaf.basic.BasicComboBoxUI;


public class myCoboboxUI extends BasicComboBoxUI {
	public myCoboboxUI() {
		
	}
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		myBorder border = new myBorder(5);
        comboBox.setBorder(border);
        comboBox.setBackground(Color.white);
        arrowButton.setBackground(new Color(235,235,235));
        
        JTextField txt = (JTextField) comboBox.getEditor().getEditorComponent();
        
        
	}
	class myBorder extends EmptyBorder{
		private Color color = Color.gray;
		public myBorder(int border) {
			super(border,border,border,border);
		}
		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setColor(color);
			g2.drawRect(x, y, width-1, height-1);
		}
	}
}
