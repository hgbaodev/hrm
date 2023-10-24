package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class RecruitmentForm extends JPanel{
	private TuyenDungView tdv;
	private UngVienView Uvv;
	private JLabel lb1;
	private JLabel lb2;
	public RecruitmentForm() {
		init();
	}
	public void init() {
		this.setLayout(null);
		JPanel frame = new JPanel();
		frame.setBounds(10,10,1080,690);
		frame.setBackground(Color.white);
		frame.setLayout(null);
		this.add(frame);
		
		lb1 = new JLabel("ỨNG VIÊN");
		lb1.setFont(new Font("Arial", 1, 13));
		lb1.setBounds(20,5,80,30);
		
		lb1.setForeground(new Color(0,0,0,140));
		frame.add(lb1);
		
		lb2 = new JLabel("TUYỂN DỤNG");
		lb2.setFont(new Font("Arial", 1, 13));
		lb2.setBounds(110,5,100,30);
		lb2.setForeground(new Color(0,0,0,60));
		frame.add(lb2);
		
		JPanel panelLineLight = new JPanel();
		panelLineLight.setBounds(15,35,lb1.getWidth(),4);
		panelLineLight.setBackground(Color.decode("#00a8ff"));
		frame.add(panelLineLight);
		JPanel panelLine = new JPanel();
		panelLine.setBounds(0,35,1100,4);
		panelLine.setBackground(Color.decode("#ecf0f1"));
		frame.add(panelLine);
		
		JPanel frameContent = new JPanel();
		frameContent.setBounds(0,40,1080,650);
		frame.add(frameContent);
		frameContent.setLayout(new CardLayout());
		
		tdv = new TuyenDungView();
		tdv.setBackground(Color.white);
		frameContent.add(tdv,0);
		
		Uvv = new UngVienView();
		Uvv.setBackground(Color.white);
		frameContent.add(Uvv,1);
		
		
		
		tdv.setVisible(false);
		Uvv.setVisible(true);
		
		lb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tdv.setVisible(false);
				Uvv.setVisible(true);
				lb1.setForeground(new Color(0,0,0,140));
				lb2.setForeground(new Color(0,0,0,60));
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i>=15;i-=2) {
							panelLineLight.setBounds(i,35,lb1.getWidth(),4);
							repaint();
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		lb2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tdv.setVisible(true);
				Uvv.setVisible(false);
				lb2.setForeground(new Color(0,0,0,140));
				lb1.setForeground(new Color(0,0,0,60));
				new Thread(new Runnable() {
					public void run() {
						for(int i=panelLineLight.getX();i<=lb2.getX()-5;i+=2) {
							panelLineLight.setBounds(i,35,lb2.getWidth(),4);
							repaint();
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		
	}
	public TuyenDungView getTuyenDungView() {
		return this.tdv;
	}
	public UngVienView getUngVienView() {
		return this.Uvv;
	}
	public JLabel getLb1() {
		return this.lb1;
	}
	public JLabel getLb2() {
		return this.lb2;
	}
}
