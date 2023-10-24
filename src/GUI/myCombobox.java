package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class myCombobox<E> extends JComboBox<E>{
	private JLabel arrow;
	
	public myCombobox(){
		setBackground(Color.white);
		setUI(new myCoboboxUI());
		this.setRenderer(new MyRenderer());
		removeArrow(this);
		this.setLayout(null);
		arrow = new JLabel("");
		arrow.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/assets/img/arrow_cbb2.png")).getImage().getScaledInstance(13, 13, Image.SCALE_AREA_AVERAGING)));
		arrow.setBounds(0,0,0,0);
		this.add(arrow);
		
	}
	public void showArrow() {
		arrow.setBounds(this.getWidth()-this.getHeight()+8,0,this.getHeight(),this.getHeight());
	}
	private static class MyRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                                                      int index, boolean isSelected, boolean cellHasFocus) {

            JComponent comp = (JComponent) super.getListCellRendererComponent(list,
                    value, index, isSelected, cellHasFocus);

            list.setBackground(Color.white);
            list.setForeground(new Color(0,0,0,200));
            list.setSelectionForeground(Color.WHITE);
            list.setSelectionBackground(Color.decode("#3498db"));
            list.setOpaque(false);
            comp.setPreferredSize(new Dimension(200,24));
            return comp;
        }
    }
	private static void removeArrow(Container container) {
	      Component[] c = container.getComponents();
	      for (Component res : c) {
	         if (res instanceof AbstractButton) {
	            container.remove(res);
	         }
	     }
	 }
	
}
