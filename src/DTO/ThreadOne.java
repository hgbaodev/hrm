package DTO;
//package model;
//
//import access_table.access_TUYENDUNG;
//import view.TuyenDungView_Them;
//
//public class ThreadOne extends Thread{
//	private TuyenDungView_Them tdv_t;
//	
//	public ThreadOne(TuyenDungView_Them tdv_t) {
//		this.tdv_t = tdv_t;
//	}
//	public void run() {
//		String[] a= access_TUYENDUNG.getMaTuyenDung();
//		String b="";
//		while(true) {
//			int checkMaTuyenDung=0;
//			int checkMaLuongToiThieu=0;
//
//			for(int i=0;i<a.length;i++) {
//				if(tdv_t.getTextField_MaTuyenDung().getText().equals(a[i])) {
//					b=new String(a[i]);
//					break;
//				}
//			}
//			if(b.equals("")) {				
//				tdv_t.getLabel_alert_MaTuyenDung().setText(" ");
//				tdv_t.getLabel_HocVan().setBounds(50,170,230,30);
//				tdv_t.getComboBox_HocVan().setBounds(50,200,170,30);
//				tdv_t.getLabel_SoLuongTuyen().setBounds(50,240,120,30);
//				tdv_t.getTextField_SoLuongTuyen().setBounds(50,270,170,30);
//				tdv_t.getLabel_DoTuoi().setBounds(50,310,230,30);
//				tdv_t.getComboBox_DoTuoi().setBounds(50,340,170,30);
//				tdv_t.getLabel_GioiTinh().setBounds(50,380,230,30);
//				tdv_t.getFemaleCheckBox().setBounds(110,410,50,30);
//				tdv_t.getMaleCheckBox().setBounds(60,410,50,30);
//				tdv_t.getNullCheckBox().setBounds(160,410,80,30);
//				tdv_t.getLabel_alert_SLTuyen().setBounds(50,300,170,20);
//				checkMaTuyenDung=0;
//				
//			}
//			else {
//				tdv_t.getLabel_alert_MaTuyenDung().setText("Mã "+ b +" đã tồn tại");
//				tdv_t.getLabel_HocVan().setBounds(50,190,230,30);
//				tdv_t.getComboBox_HocVan().setBounds(50,220,170,30);
//				tdv_t.getLabel_SoLuongTuyen().setBounds(50,260,120,30);
//				tdv_t.getTextField_SoLuongTuyen().setBounds(50,290,170,30);
//				tdv_t.getLabel_DoTuoi().setBounds(50,330,230,30);
//				tdv_t.getComboBox_DoTuoi().setBounds(50,360,170,30);
//				tdv_t.getLabel_GioiTinh().setBounds(50,400,230,30);
//				tdv_t.getFemaleCheckBox().setBounds(110,430,50,30);
//				tdv_t.getMaleCheckBox().setBounds(60,430,50,30);
//				tdv_t.getNullCheckBox().setBounds(160,430,80,30);
//				tdv_t.getLabel_alert_SLTuyen().setBounds(50,320,170,20);
//				checkMaTuyenDung=1;
//				b="";
//			}
//			//TextField_SoLuuong
//			if(tdv_t.getTextField_SoLuongTuyen().getText().toString().equals("")== true) {
//				tdv_t.getLabel_alert_SLTuyen().setText(" ");
//			}
//			else {
//				try {
//				    int num = Integer.parseInt(tdv_t.getTextField_SoLuongTuyen().getText().toString());
//				    if(num<=0) {
//						tdv_t.getLabel_alert_SLTuyen().setText("Số lượng tuyển phải lớn hơn 0");
//						if(checkMaTuyenDung==1) {
//							tdv_t.getLabel_DoTuoi().setBounds(50,350,230,30);
//							tdv_t.getComboBox_DoTuoi().setBounds(50,380,170,30);
//							tdv_t.getLabel_GioiTinh().setBounds(50,420,230,30);
//							tdv_t.getFemaleCheckBox().setBounds(110,450,50,30);
//							tdv_t.getMaleCheckBox().setBounds(60,450,50,30);
//							tdv_t.getNullCheckBox().setBounds(160,450,80,30);
//						}
//						else {
//							tdv_t.getLabel_DoTuoi().setBounds(50,330,230,30);
//							tdv_t.getComboBox_DoTuoi().setBounds(50,360,170,30);
//							tdv_t.getLabel_GioiTinh().setBounds(50,400,230,30);
//							tdv_t.getFemaleCheckBox().setBounds(110,430,50,30);
//							tdv_t.getMaleCheckBox().setBounds(60,430,50,30);
//							tdv_t.getNullCheckBox().setBounds(160,430,80,30);
//						}
//
//				    }
//				    else {
//						tdv_t.getLabel_alert_SLTuyen().setText(" ");
////						tdv_t.getLabel_DoTuoi().setBounds(50,330,230,30);
////						tdv_t.getComboBox_DoTuoi().setBounds(50,360,170,30);
////						tdv_t.getLabel_GioiTinh().setBounds(50,400,230,30);
////						tdv_t.getFemaleCheckBox().setBounds(110,430,50,30);
////						tdv_t.getMaleCheckBox().setBounds(60,430,50,30);
////						tdv_t.getNullCheckBox().setBounds(160,430,80,30);
//						
//				    }
//				} catch (NumberFormatException e) {
//					tdv_t.getLabel_alert_SLTuyen().setText("Số lượng tuyển phải là một con số");
//					if(checkMaTuyenDung==1) {
//						tdv_t.getLabel_DoTuoi().setBounds(50,350,230,30);
//						tdv_t.getComboBox_DoTuoi().setBounds(50,380,170,30);
//						tdv_t.getLabel_GioiTinh().setBounds(50,420,230,30);
//						tdv_t.getFemaleCheckBox().setBounds(110,450,50,30);
//						tdv_t.getMaleCheckBox().setBounds(60,450,50,30);
//						tdv_t.getNullCheckBox().setBounds(160,450,80,30);
//					}
//					else {
//						tdv_t.getLabel_DoTuoi().setBounds(50,330,230,30);
//						tdv_t.getComboBox_DoTuoi().setBounds(50,360,170,30);
//						tdv_t.getLabel_GioiTinh().setBounds(50,400,230,30);
//						tdv_t.getFemaleCheckBox().setBounds(110,430,50,30);
//						tdv_t.getMaleCheckBox().setBounds(60,430,50,30);
//						tdv_t.getNullCheckBox().setBounds(160,430,80,30);
//					}
//				}
//			}
//			//TextField_LuongToiThieu
//			if(tdv_t.getTextField_MucLuongToiThieu().getText().toString().equals("")== true) {
//				tdv_t.getLabel_alert_LuongToiThieu().setText(" ");
//				tdv_t.getLabel_MucLuongToiDa().setBounds(270,170,230,30);
//				tdv_t.getTextField_MucLuongToiDa().setBounds(270,200,170,30);
//				tdv_t.getLabel_ChucVu().setBounds(270,240,230,30);
//				tdv_t.getComboBox_ChucVuCongTy().setBounds(270,270,170,30);
//				tdv_t.getLabel_HanNop().setBounds(270,310,230,30);
//				tdv_t.getTextField_HanNop().setBounds(270,340,170,30);
//				tdv_t.getLabel_alert_LuongToiDa().setBounds(270,230,170,20);
//			}
//			else {
//				try {
//				    int num = Integer.parseInt(tdv_t.getTextField_MucLuongToiThieu().getText().toString());
//				    if(num<=0) {
//						tdv_t.getLabel_alert_LuongToiThieu().setText("Lương phải lớn hơn 0");
//						tdv_t.getLabel_MucLuongToiDa().setBounds(270,190,230,30);
//						tdv_t.getTextField_MucLuongToiDa().setBounds(270,220,170,30);
//						tdv_t.getLabel_ChucVu().setBounds(270,260,230,30);
//						tdv_t.getComboBox_ChucVuCongTy().setBounds(270,290,170,30);
//						tdv_t.getLabel_HanNop().setBounds(270,330,230,30);
//						tdv_t.getTextField_HanNop().setBounds(270,360,170,30);
//						tdv_t.getLabel_alert_LuongToiDa().setBounds(270,250,170,20);
//						checkMaLuongToiThieu=1;
//				    }
//				    else {
//						tdv_t.getLabel_alert_LuongToiThieu().setText(" ");
//						tdv_t.getLabel_MucLuongToiDa().setBounds(270,170,230,30);
//						tdv_t.getTextField_MucLuongToiDa().setBounds(270,200,170,30);
//						tdv_t.getLabel_ChucVu().setBounds(270,240,230,30);
//						tdv_t.getComboBox_ChucVuCongTy().setBounds(270,270,170,30);
//						tdv_t.getLabel_HanNop().setBounds(270,310,230,30);
//						tdv_t.getTextField_HanNop().setBounds(270,340,170,30);
//						tdv_t.getLabel_alert_LuongToiDa().setBounds(270,230,170,20);
//						checkMaLuongToiThieu=0;
//
//				    }
//				} catch (NumberFormatException e) {
//					tdv_t.getLabel_alert_LuongToiThieu().setText("Lương phải là một con số");
//					tdv_t.getLabel_MucLuongToiDa().setBounds(270,190,230,30);
//					tdv_t.getTextField_MucLuongToiDa().setBounds(270,220,170,30);
//					tdv_t.getLabel_ChucVu().setBounds(270,260,230,30);
//					tdv_t.getComboBox_ChucVuCongTy().setBounds(270,290,170,30);
//					tdv_t.getLabel_HanNop().setBounds(270,330,230,30);
//					tdv_t.getTextField_HanNop().setBounds(270,370,170,30);
//					tdv_t.getLabel_alert_LuongToiDa().setBounds(270,250,170,20);
//					checkMaLuongToiThieu=1;
//
//				}
//			}
//			
//			//TextField_LuongToiDa
//			if(tdv_t.getTextField_MucLuongToiDa().getText().toString().equals("")== true) {
//				tdv_t.getLabel_alert_LuongToiDa().setText(" ");
//			}
//			else {
//				try {
//				    int num = Integer.parseInt(tdv_t.getTextField_MucLuongToiDa().getText().toString());
//				    if(num<0) {
//						tdv_t.getLabel_alert_LuongToiDa().setText("Lương phải lớn hơn 0");
//						if(checkMaLuongToiThieu==1) {
//							tdv_t.getLabel_ChucVu().setBounds(270,280,230,30);
//							tdv_t.getComboBox_ChucVuCongTy().setBounds(270,310,170,30);
//							tdv_t.getLabel_HanNop().setBounds(270,350,230,30);
//							tdv_t.getTextField_HanNop().setBounds(270,390,170,30);
//						}
//						else {
//							tdv_t.getLabel_ChucVu().setBounds(270,260,230,30);
//							tdv_t.getComboBox_ChucVuCongTy().setBounds(270,290,170,30);
//							tdv_t.getLabel_HanNop().setBounds(270,330,230,30);
//							tdv_t.getTextField_HanNop().setBounds(270,370,170,30);
//						}
//
//				    }
//				    else {
//						tdv_t.getLabel_alert_LuongToiDa().setText(" ");
//				    }
//				    if(tdv_t.getLabel_alert_LuongToiThieu().getText().equals(" ")==true || tdv_t.getLabel_alert_LuongToiThieu().getText().equals("")==true) {
//			    		if(Integer.parseInt(tdv_t.getTextField_MucLuongToiThieu().getText().toString())>Integer.parseInt(tdv_t.getTextField_MucLuongToiDa().getText().toString())) {
//				    		tdv_t.getLabel_alert_LuongToiDa().setText("Lương tối đa phải lớn hơn lương tối thiểu");
//				    		if(checkMaLuongToiThieu==1) {
//								tdv_t.getLabel_ChucVu().setBounds(270,280,230,30);
//								tdv_t.getComboBox_ChucVuCongTy().setBounds(270,310,170,30);
//								tdv_t.getLabel_HanNop().setBounds(270,350,230,30);
//								tdv_t.getTextField_HanNop().setBounds(270,390,170,30);
//
//							}
//							else {
//								tdv_t.getLabel_ChucVu().setBounds(270,260,230,30);
//								tdv_t.getComboBox_ChucVuCongTy().setBounds(270,290,170,30);
//								tdv_t.getLabel_HanNop().setBounds(270,330,230,30);
//								tdv_t.getTextField_HanNop().setBounds(270,370,170,30);
//							}
//			    		}
//			    		else {
//							tdv_t.getLabel_alert_LuongToiDa().setText(" ");
//			    		}
//			    	}
//			    	else
//			    	{
//			    		tdv_t.getLabel_alert_LuongToiDa().setText("Vui lòng nhâp vào lương tối thiểu");
//			    		if(checkMaLuongToiThieu==1) {
//							tdv_t.getLabel_ChucVu().setBounds(270,280,230,30);
//							tdv_t.getComboBox_ChucVuCongTy().setBounds(270,310,170,30);
//							tdv_t.getLabel_HanNop().setBounds(270,350,230,30);
//							tdv_t.getTextField_HanNop().setBounds(270,390,170,30);
//
//
//						}
//						else {
//							tdv_t.getLabel_ChucVu().setBounds(270,260,230,30);
//							tdv_t.getComboBox_ChucVuCongTy().setBounds(270,290,170,30);
//							tdv_t.getLabel_HanNop().setBounds(270,330,230,30);
//							tdv_t.getTextField_HanNop().setBounds(270,370,170,30);
//						}
//
//
//			    	}
//				} catch (NumberFormatException e) {
//					tdv_t.getLabel_alert_LuongToiDa().setText("Lương phải là một con số");
//					if(checkMaLuongToiThieu==1) {
//						tdv_t.getLabel_ChucVu().setBounds(270,280,230,30);
//						tdv_t.getComboBox_ChucVuCongTy().setBounds(270,310,170,30);
//						tdv_t.getLabel_HanNop().setBounds(270,350,230,30);
//						tdv_t.getTextField_HanNop().setBounds(270,390,170,30);
//
//					}
//					else {
//						tdv_t.getLabel_ChucVu().setBounds(270,260,230,30);
//						tdv_t.getComboBox_ChucVuCongTy().setBounds(270,290,170,30);
//						tdv_t.getLabel_HanNop().setBounds(270,330,230,30);
//						tdv_t.getTextField_HanNop().setBounds(270,370,170,30);
//
//					}
//
//				}
//			}
////			if(tdv_t.getTextField_SoLuongTuyen().getText().toString().equals("")== false || tdv_t.getTextField_SoLuongTuyen().getText().toString().equals("-")==true) {
////				System.out.println("Vào được rồi");
////				if(tdv_t.getTextField_SoLuongTuyen().getText()) {
////					tdv_t.getLabel_alert_SLTuyen().setText("Số lượng tuyển phải lớn hơn 0");
////				}
////			}
////			else {
////				System.out.println("Hãy nhập vào số");
////			}
//            try {
//                Thread.sleep(1000); // Đợi 1 giây trước khi đếm tiếp
//            } catch (InterruptedException e) {
//                // Nếu tiến trình đã bị interrupt trong lúc đợi, dừng tiến trình
//                return;
//            }
//
//		}
//	}
//}
