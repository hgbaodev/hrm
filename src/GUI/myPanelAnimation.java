package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author RAVEN
 */
public class myPanelAnimation extends JPanel {
	private Color color;
    private Shape shape;
    private final RippleEffect rippleEffect;
    private JLabel lbtitle;
    private JLabel lbicon;
    private String icon_normal;
    private String icon_special;
    public myPanelAnimation() {
    	color = new Color(0,0,0,0);
    	rippleEffect = new RippleEffect(this);
    	this.setOpaque(false);
        setBorder(new EmptyBorder(8, 5, 8, 5));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        init();
    }
    public void init() {
    	this.setLayout(null);
    	lbicon = new JLabel("");
    	lbicon.setBounds(20, 5, 20, 20);
		this.add(lbicon);
		Font font = new Font("Arial",1,13);
		
		lbtitle = new JLabel("Tiêu đề");
		lbtitle.setBounds(55, 5, 201, 20);
		lbtitle.setForeground(new Color(0,0,0,160));
		lbtitle.setFont(font);
		this.add(lbtitle);
    }
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        g2.setColor(color);
        g2.fill(shape);
        rippleEffect.reder(g2, shape);
        g2.dispose();
        super.paintComponent(grphcs);
    }
    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        shape = new Rectangle(i2,i3);
    }
    public void setColor(Color color) {
    	this.color = color;
    }
    public void setTitle(String title) {
    	lbtitle.setText(title);
    }
    public String getTitle() {
    	return this.lbtitle.getText();
    }
    public void setColorText(Color color) {
    	lbtitle.setForeground(color);
    }
    public void useIconSpecial() {
    	setIcon(icon_special);
    }
    public void useIconNormal() {
    	setIcon(icon_normal);
    }
    public void setIconNormal(String icon) {
    	this.icon_normal = icon;
    	setIcon(icon_normal);
    }
    public void setIconSpecial(String icon) {
    	this.icon_special = icon;
    }
    public void setIcon(String icon) {
    	lbicon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/menu_img/"+icon)).getImage().getScaledInstance(18, 18, Image.SCALE_AREA_AVERAGING)));
    }
    public void setIconPosition(int x,int y) {
    	lbicon.setBounds(x,y,lbicon.getWidth(),lbicon.getHeight());
    }
}
