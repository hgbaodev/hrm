package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import BUS.DANHSACHHOPDONG;
import GUI.ConTractForm1;
import GUI.employeeForm1;
import run.App;

public class timKiemHopDong implements KeyListener{

	private App app;
	private int index;
	public timKiemHopDong(App app) {
		this.app = app;
		index = 0;
	}

	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static DANHSACHHOPDONG find(App app,DANHSACHHOPDONG data) {
		DANHSACHHOPDONG danhSachTimKiem = null;
		String find = app.getContent().getContractForm().getConTractForm1().getTextFromFindField();
		danhSachTimKiem = new DANHSACHHOPDONG(data.findEmployee(find));
		return danhSachTimKiem;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		index++;
		// TODO Auto-generated method stub
		DANHSACHHOPDONG danhSachTimKiem = find(app,locHopDong.filter(app));
		app.getContent().getContractForm().getConTractForm1().setData(danhSachTimKiem.getObjectToRender());
		
//		app.repaint();
	}
	



	

}
