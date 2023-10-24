package DTO;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.DANHSACHNHANVIEN;
import DAO.access_PHONGBAN;









public class EXCEL {
	public static void exportDepartmentData(Object [][]str,String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        // Khởi tạo một worksheet mới từ workbook 
        XSSFSheet sheet = workbook.createSheet("Phòng ban");
        // Dữ liệu sẽ được ghi xuống file exel
       

        Row row = sheet.createRow(1);
        String nameColumn[] = {"STT","Phòng ban","Ngày thành lập","Trưởng phòng","Ngày nhận chức","Nhân viên","Lương trung bình"};
        for(int i=0;i<7;i++) {
        	Cell cell = row.createCell(i);
        	cell.setCellValue(nameColumn[i]);
        }
        for(int i=2;i<str.length+2;i++) {
        	row = sheet.createRow(i);
        	for(int j=0;j<7;j++) {
        		Cell cell = row.createCell(j);
        		cell.setCellValue((String)str[i-2][j]);
        	}
        }
        try {
            // ghi dữ liệu xuống file
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Đã lưu file excel.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void exportBangChamCongData(Object [][]str,String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        // Khởi tạo một worksheet mới từ workbook 
        XSSFSheet sheet = workbook.createSheet("Chấm công");
        // Dữ liệu sẽ được ghi xuống file exel
       

        Row row = sheet.createRow(1);
        String nameColumn[] = {"STT","Mã chấm công","Nhân viên","Thời gian","Làm việc","Ngày nghỉ","Ngày trễ","Giờ làm thêm"};
        for(int i=0;i<7;i++) {
        	Cell cell = row.createCell(i);
        	cell.setCellValue(nameColumn[i]);
        }
        for(int i=2;i<str.length+2;i++) {
        	row = sheet.createRow(i);
        	for(int j=0;j<nameColumn.length;j++) {
        		Cell cell = row.createCell(j);
        		cell.setCellValue((String)str[i-2][j]);
        		
        	}
        }
        try {
            // ghi dữ liệu xuống file
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Đã lưu file excel.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void exportSalaryData(Object [][]str,String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        // Khởi tạo một worksheet mới từ workbook 
        XSSFSheet sheet = workbook.createSheet("Bảng lương tháng");
        // Dữ liệu sẽ được ghi xuống file exel
       

        Row row = sheet.createRow(1);
        String nameColumn[] = {"STT","Nhân viên","Lương cơ bản","Lương thực tế","Phụ cấp","Lương thưởng","Khoản trừ","Thuế","Thực lãnh"};
        for(int i=0;i<nameColumn.length;i++) {
        	Cell cell = row.createCell(i);
        	cell.setCellValue(nameColumn[i]);
        }
        for(int i=2;i<str.length+2;i++) {
        	row = sheet.createRow(i);
        	for(int j=0;j<nameColumn.length;j++) {
        		Cell cell = row.createCell(j);
        		cell.setCellValue((String)str[i-2][j]);
        		
        	}
        }
        try {
            // ghi dữ liệu xuống file
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Đã lưu file excel.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void exportEmployeeData(Object [][]str,String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        // Khởi tạo một worksheet mới từ workbook 
        XSSFSheet sheet = workbook.createSheet("Nhân viên");
        // Dữ liệu sẽ được ghi xuống file exel
       

        Row row = sheet.createRow(1);
        String nameColumn[] = {"STT","Mã số","Họ và tên","Giới tính","Ngày sinh","Địa chỉ","Dân tộc","Tôn giáo","Tình trạng hôn nhân","Số điện thoại","Email","Phòng ban","Chức vụ","Ngày nhận chức","Mức lương","Loại hình"};
        for(int i=0;i<nameColumn.length;i++) {
        	Cell cell = row.createCell(i);
        	cell.setCellValue(nameColumn[i]);
        }
        for(int i=2;i<str.length+2;i++) {
        	row = sheet.createRow(i);
        	for(int j=0;j<nameColumn.length;j++) {
        		Cell cell = row.createCell(j);
        		cell.setCellValue((String)str[i-2][j]);
        	}
        }
        try {
            // ghi dữ liệu xuống file
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Đã lưu file excel.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void exportContractData(Object [][]str,String path) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        // Khởi tạo một worksheet mới từ workbook 
        XSSFSheet sheet = workbook.createSheet("Hợp đồng");
        // Dữ liệu sẽ được ghi xuống file exel
       

        Row row = sheet.createRow(1);
        String nameColumn[] = {"STT","Nhân viên","Phòng ban","Từ ngày","Đến ngày","Loại hợp đồng","Lương cơ bản"};
        for(int i=0;i<nameColumn.length;i++) {
        	Cell cell = row.createCell(i);
        	cell.setCellValue(nameColumn[i]);
        }
        for(int i=2;i<str.length+2;i++) {
        	row = sheet.createRow(i);
        	for(int j=0;j<nameColumn.length;j++) {
        		Cell cell = row.createCell(j);
        		
        			cell.setCellValue((String)str[i-2][j]);
        		
        	}
        }
        try {
            // ghi dữ liệu xuống file
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
            System.out.println("Đã lưu file excel.");
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static DANHSACHNHANVIEN importEmployeeData(String path) {
		DANHSACHNHANVIEN list = new DANHSACHNHANVIEN();
		try {
	        FileInputStream file = new FileInputStream(new File(path));
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        int rows = sheet.getPhysicalNumberOfRows();
	        System.out.println(rows);
	       for(int r=1;r<rows;r++){
	            try {
	            	Row row = sheet.getRow(r);
	            	if(row ==null) {
	            		System.out.println("row null");
	            	}
		            
		           ArrayList<String> listData = new ArrayList<>();
		           for(int i=0;i<=24;i++) {
		        	   if(row.getCell(i).getCellType()==CellType.STRING) {
		        		   listData.add(row.getCell(i).getStringCellValue());
		        	   }else {
		        		   listData.add(SUPPORT.changeSalaryToFormatStringToFix(row.getCell(i).getNumericCellValue()));
		        	   }
		           }
		           String arrDiaChi[] = listData.get(5).split(",");
		            System.out.println("heheheheh");
		            System.out.println(arrDiaChi.length);
		            String arrDiaChi2[] = arrDiaChi[0].split(" ");
		            System.out.println(arrDiaChi2.length);
		            String duong = "";
		            for(int i=1;i<arrDiaChi2.length;i++) {
		            	duong+=arrDiaChi2[i]+" ";
		            }
		            
		            String data[] = new String[] {
		            		listData.get(1),
		            		listData.get(2),
		            		listData.get(3),
		            		listData.get(4),
		            		listData.get(6),
		            		listData.get(7),
		            	arrDiaChi2[0],duong,arrDiaChi[1],arrDiaChi[2],arrDiaChi[3],
		            	listData.get(14),
		            	listData.get(15),
		            	listData.get(16),
		            	listData.get(11),
		            	listData.get(12),
		            	listData.get(13),
		            	listData.get(8),
		            	listData.get(9),
		            	listData.get(10),
		            	listData.get(17),
		            	listData.get(18),
		            	listData.get(19),
		            	listData.get(20),
		            	listData.get(21),
		            	listData.get(22),
		            	listData.get(23),
		            	listData.get(24),
		            	"none_user.jpg"
		            };
		            if(access_PHONGBAN.getMaSoTuTen(data[20])==null) {
		            	continue;
		            }
		            if(CHECK.checkEmployeeDataImportExcel(data)) {
		            	list.addEmployeeFromStringData(data);
		            }
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
	        }
	        file.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		System.out.println(list.getList().size());
		return list;
	}

}
