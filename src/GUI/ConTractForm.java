package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConTractForm extends JPanel {

	private ConTractForm1 hopDongForm;
	private ConTractForm2 giaHanHopDongForm;
	private ConTractForm3 thongKeForm;	
	private ContractForm4 kiHopDongForm;
	private JLabel lb1;
	private JLabel lb3;
	private JLabel lb4;
	public ConTractForm() {
		init();
	}

	public void init() {
		this.setLayout(null);
		JPanel frame = new JPanel();
		frame.setBounds(10 , 10, 1080, 695);
		frame.setBackground(Color.white);
		frame.setLayout(null);
		this.add(frame);

		lb1 = new JLabel("HỢP ĐỒNG");
		lb1.setFont(new Font("Arial", 1, 13));
		lb1.setBounds(10, 5, 80, 30);
		lb1.setForeground(new Color(0, 0, 0, 140));
		frame.add(lb1);

		lb3 = new JLabel("KÍ HỢP ĐỒNG");
		lb3.setFont(new Font("Arial", 1, 13));
		lb3.setBounds(100, 5, 100, 30);
		lb3.setForeground(new Color(0, 0, 0, 60));
		frame.add(lb3);
		
		lb4 = new JLabel("THỐNG KÊ");
		lb4.setFont(new Font("Arial", 1, 13));
		lb4.setBounds(210, 5, 80, 30);
		lb4.setForeground(new Color(0, 0, 0, 60));
		frame.add(lb4);

		JPanel panelLineLight = new JPanel();
		panelLineLight.setBounds(5, 35, lb1.getWidth(), 4);
		panelLineLight.setBackground(Color.decode("#00a8ff"));
		frame.add(panelLineLight);
		JPanel panelLine = new JPanel();
		panelLine.setBounds(0, 35, 1100, 4);
		panelLine.setBackground(Color.decode("#ecf0f1"));
		frame.add(panelLine);

		JPanel frameContent = new JPanel();
		frameContent.setBounds(0, 40, 1080, 680);
		frame.add(frameContent);
		frameContent.setLayout(new CardLayout());

		hopDongForm = new ConTractForm1();
		frameContent.add(hopDongForm, 0);

		giaHanHopDongForm = new ConTractForm2();
		frameContent.add(giaHanHopDongForm, 1);
		
		kiHopDongForm = new ContractForm4();
		frameContent.add(kiHopDongForm);
		
		thongKeForm = new ConTractForm3();
		frameContent.add(thongKeForm, 2);



		lb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showFrame(0);
				lb1.setForeground(new Color(0, 0, 0, 140));
				lb4.setForeground(new Color(0, 0, 0, 60));
				lb3.setForeground(new Color(0, 0, 0, 60));
				new Thread(new Runnable() {
					public void run() {
						for (int i = panelLineLight.getX(); i >= 5; i -= 2) {
							panelLineLight.setBounds(i, 35, lb1.getWidth(), 4);
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
		lb3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showFrame(3);
				lb3.setForeground(new Color(0, 0, 0, 140));
				lb1.setForeground(new Color(0, 0, 0, 60));
				lb4.setForeground(new Color(0, 0, 0, 60));
				new Thread(new Runnable() {
					public void run() {
						if(panelLineLight.getX()<lb3.getX()) {
							for (int i = panelLineLight.getX(); i <= lb3.getX() - 5; i += 2) {
								panelLineLight.setBounds(i, 35, lb3.getWidth(), 4);
								repaint();
								try {
									Thread.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}else {
							for (int i = panelLineLight.getX(); i >= lb3.getX() -5; i -= 2) {
								panelLineLight.setBounds(i, 35, lb3.getWidth(), 4);
								repaint();
								try {
									Thread.sleep(2);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}).start();
			}
		});
		lb4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showFrame(2);
				lb4.setForeground(new Color(0, 0, 0, 140));
				lb1.setForeground(new Color(0, 0, 0, 60));
				lb3.setForeground(new Color(0, 0, 0, 60));
				new Thread(new Runnable() {
					public void run() {
						for (int i = panelLineLight.getX(); i <= lb4.getX() - 5; i += 2) {
							panelLineLight.setBounds(i, 35, lb4.getWidth(), 4);
							repaint();
							try {
								Thread.sleep(2);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		showFrame(0);
	}	
	
	public void showFrame(int index) {
		if(index==0) {
			hopDongForm.setVisible(true);
			giaHanHopDongForm.setVisible(false);
			thongKeForm.setVisible(false);
			kiHopDongForm.setVisible(false);
		}else if(index==1){
			hopDongForm.setVisible(false);
			giaHanHopDongForm.setVisible(true);
			thongKeForm.setVisible(false);
			kiHopDongForm.setVisible(false);
		}else if(index==2){
			hopDongForm.setVisible(false);
			giaHanHopDongForm.setVisible(false);
			thongKeForm.setVisible(true);
			kiHopDongForm.setVisible(false);
		}else {
			hopDongForm.setVisible(false);
			giaHanHopDongForm.setVisible(false);
			thongKeForm.setVisible(false);
			kiHopDongForm.setVisible(true);
		}
	}
	public JLabel getLb1() {
		return this.lb1;
	}
	public JLabel getLb2() {
		return this.lb3;
	}
	public JLabel getLb3() {
		return this.lb4;
	}
	public ConTractForm1 getConTractForm1() {
		return this.hopDongForm;
	}

	public ConTractForm2 getConTractForm2() {
		return this.giaHanHopDongForm;
	}

	public ConTractForm3 getConTractForm3() {
		return this.thongKeForm;
	}
	public ContractForm4 getConTractForm4() {
		return this.kiHopDongForm;
	}
}
