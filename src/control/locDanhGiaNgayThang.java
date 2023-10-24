package control;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BUS.DANHSACHBANGDANHGIA;
import run.App;

public class locDanhGiaNgayThang implements DocumentListener{
	private App app;
	public locDanhGiaNgayThang(App app) {
		this.app = app;
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		DANHSACHBANGDANHGIA ds = locXapSepDanhGia.loc(app);
		app.getContent().getDanhGiaForm().setData(ds.getObjectToRender());
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
