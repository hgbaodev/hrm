package GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;

public class myButton extends JButton{
	public myButton() {
		setUI(new designButton());
	}
	public myButton(String text) {
		super(text);
		setUI(new designButton());
	}
}
class designButton extends ButtonUI{
    public void installUI (JComponent c) {
        super.installUI(c);
        AbstractButton button = (AbstractButton) c;
        button.setOpaque(false);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
    }
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }
//    private void paintBackground (Graphics g, JComponent c, int yOffset) {
//        Dimension size = c.getSize();
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setColor(c.getBackground().darker());
//        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 6, 6);
//        g.setColor(c.getBackground());
//        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 6, 6);
//    }
    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(c.getBackground());
        g.fillRoundRect(0, 0, size.width, size.height, 6, 6);
    }
}