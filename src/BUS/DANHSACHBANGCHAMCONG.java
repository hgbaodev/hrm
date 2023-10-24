package BUS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import DAO.access_BANGCHAMCONG;
import DTO.BANGCHAMCONG;
import DTO.SUPPORT;

/**
 *
 * @author Jhin
 */
public class DANHSACHBANGCHAMCONG {

    private access_BANGCHAMCONG bcc;
    private ArrayList<BANGCHAMCONG> list;
    private ArrayList<BANGCHAMCONG> list_one;
    
    public void TenNhanVienKhongTrung() {
    	HashMap<String, BANGCHAMCONG> uniqueElements = new HashMap<String, BANGCHAMCONG>();

        for (BANGCHAMCONG element : list) {
            if (!uniqueElements.containsKey(element.getMaNV())) {
                uniqueElements.put(element.getMaNV(), element);
            }
        }
        list_one = new ArrayList<BANGCHAMCONG>(uniqueElements.values());
    }
    public DANHSACHBANGCHAMCONG() {
        this.bcc = new access_BANGCHAMCONG();
        this.list = new ArrayList<>();
    }

    public DANHSACHBANGCHAMCONG(ArrayList<BANGCHAMCONG> list) {
        this.list = list;
    }

    public ArrayList<BANGCHAMCONG> getList() {
        return list;
    }

    /* ----------------------------------------------------------------------------- */
    public void getDataFromDatabase() {
        this.list = access_BANGCHAMCONG.getList();
    }

    public BANGCHAMCONG getBangChamCong(String maBCC) {
        maBCC = maBCC.trim();
        for (BANGCHAMCONG i : list) {
            if (i.getMaBangChamCong().equalsIgnoreCase(maBCC)) {
                return i;
            }
        }
        return null;
    }

    public Object[][] getObjectseToRender() {
        int n = this.list.size();
        Object[][] obj = new Object[n][];

        for (int i = 0; i < n; i++) {
            BANGCHAMCONG temp = list.get(i);
            obj[i] = new Object[]{i + 1 + "", temp.getMaBangChamCong(), access_BANGCHAMCONG.getTen(temp.getMaBangChamCong()), temp.getThangChamCong() + "/" + temp.getNamChamCong(), temp.getSoNgayLamViec()+"", temp.getSoNgayNghi()+"", temp.getSoNgayTre()+"", temp.getSoGioLamThem()+""};
        }
        return obj;
    }
    public Object[][] getObjectseToRender_Them() {
    	TenNhanVienKhongTrung();
        int n = this.list_one.size();
        Object[][] obj = new Object[n][];
        for (int i = 0; i < n; i++) {
            BANGCHAMCONG temp = list_one.get(i);
            obj[i] = new Object[]{i + 1 + "", access_BANGCHAMCONG.getTen(temp.getMaBangChamCong()),"Chưa chấm công"};
        }
        return obj;
    }
    /* Them bcc vao list */
    public void themVaoList(BANGCHAMCONG bcc) {
        this.list.add(bcc);
    }
    
    /* Tim kiem */
    @SuppressWarnings({"UnusedAssignment", "static-access"})
    public ArrayList<BANGCHAMCONG> timBangChamCong(String find) {
        ArrayList<BANGCHAMCONG> temp = new ArrayList<>();

        find = find.trim();
        for (BANGCHAMCONG i : list) {
            if (i.getMaBangChamCong().trim().contains(find) || bcc.getTen(i.getMaBangChamCong()).toLowerCase().contains(find.toLowerCase())) {
                temp.add(i);
            }
        }
        return temp;
    }

    /* Delete */
    public void xoaBangMa(String ma) {
        for (BANGCHAMCONG i : list) {
            if (i.getMaBangChamCong().equalsIgnoreCase(ma)) {
                list.remove(i);
                return;
            }
        }
    }

    /* Sort */
    public void sortMaBCC(int type) {
        list.sort((o1, o2) -> o1.getMaBangChamCong().compareTo(o2.getMaBangChamCong()));
        if (type != 0) {
            Collections.reverse(list);
        }
    }

    public void sortMaNV(int type) {
        list.sort((o1, o2) -> o1.getMaNV().compareTo(o2.getMaNV()));
        if (type != 0) {
            Collections.reverse(list);
        }
    }

    public void sortThoiGianChamCong(int type) {

        list.sort((o1, o2) -> SUPPORT.compareDouble(o1.getNamChamCong(), o2.getNamChamCong()));
        for(int i=0; i<list.size();i++) {
        	  for(int j=i+1; j<list.size();j++) {
              		if(list.get(i).getNamChamCong() == list.get(j).getNamChamCong() && list.get(i).getThangChamCong() > list.get(j).getThangChamCong()) {
              			Collections.swap(list, i, j);
              		}
              }
        }
        if (type != 0) {
            Collections.reverse(list);
        }
    }

    // Filter access
    public ArrayList<BANGCHAMCONG> getBangChamCongTheoThang(String thang) {
        ArrayList<BANGCHAMCONG> arr = new ArrayList<>();

        for (BANGCHAMCONG i : list) {
            if ((i.getThangChamCong() + "").equals(thang)) {
                arr.add(i);
            }
        }
        return arr;
    }
    public ArrayList<BANGCHAMCONG> getBangChamCongTheoMaNV(String maNhanVien) {
        ArrayList<BANGCHAMCONG> arr = new ArrayList<>();

        for (BANGCHAMCONG i : list) {
            if (i.getMaNV().equals(maNhanVien)) {
                arr.add(i);
            }
        }
        return arr;
    }

    public ArrayList<BANGCHAMCONG> getBangChamCongTheoNam(String nam) {
        ArrayList<BANGCHAMCONG> arr = new ArrayList<>();

        for (BANGCHAMCONG i : list) {
            if ((i.getNamChamCong() + "").equals(nam)) {
                arr.add(i);
            }
        }
        return arr;
    }
}
