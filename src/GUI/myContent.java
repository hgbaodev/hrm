package GUI;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class myContent extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HomeForm homePage;
	
	private RecruitmentForm recruitmentForm;
	private EmployeeForm employeeForm;
	private BangChamCongForm timeSheetsForm;
	private ConTractForm contractForm;
	private DepartmentForm departmentForm;
	private SalaryForm salaryForm;
	private BangDanhGiaForm1 danhGiaForm;
	private AccountForm accountForm;
	private DanhGiaView danhGiaForm2;
	private ArrayList<JPanel> arr;
	public myContent() {
		init();
	}
	public void init() {
		this.setLayout(new CardLayout(0, 0));
		this.homePage = new HomeForm();	
		this.add(homePage, 0);
		JPanel test = new HomeForm();
		this.add(test,0);
		
		this.recruitmentForm = new RecruitmentForm();
		this.add(recruitmentForm, 1);
		
		// 
		this.employeeForm = new EmployeeForm();
		this.add(employeeForm, 3);
		this.contractForm = new ConTractForm();
		this.add(contractForm, 4);
		this.departmentForm = new DepartmentForm();
		this.add(departmentForm, 5);
		this.timeSheetsForm = new BangChamCongForm();
		this.add(timeSheetsForm, 6);
		this.salaryForm = new SalaryForm();
		this.add(salaryForm, 7);
		this.danhGiaForm = new BangDanhGiaForm1();
		this.add(danhGiaForm, 8);
		this.accountForm = new AccountForm();
		this.add(accountForm, 9);
		this.danhGiaForm2 = new DanhGiaView();
		this.add(danhGiaForm2,10);
		initListPage();
		showPage(0);
//		this.homePage.chart();
		
		
	}
	public void initListPage() {
		arr = new ArrayList<>();
		arr.add(homePage);
		arr.add(recruitmentForm);
		arr.add(employeeForm);
		arr.add(contractForm);
		arr.add(departmentForm);
		arr.add(timeSheetsForm);
		arr.add(salaryForm);
		arr.add(danhGiaForm);
		arr.add(accountForm);
		arr.add(danhGiaForm2);
	}
	public void resetPage() {
		for(JPanel i : arr) {
			i.setVisible(false);
		}
	}
	public void showPage(int indexPage) {
		resetPage();
		arr.get(indexPage).setVisible(true);
	}
	public HomeForm getHomePage() {
		return this.homePage;
	}
	public EmployeeForm getEmployeeForm() {
		return this.employeeForm;
	}
	public DepartmentForm getDepartmentForm() {
		return this.departmentForm;
	}
	public SalaryForm getSalaryForm() {
		return this.salaryForm;
	}
	public AccountForm getAccountForm() {
		return this.accountForm;
	}
	public RecruitmentForm getRecruitmentForm() {
		return this.recruitmentForm;
	}
	public BangDanhGiaForm1 getDanhGiaForm() {
		return this.danhGiaForm;
	}
	public ConTractForm getContractForm() {
		return this.contractForm;
	}
	public BangChamCongForm getBangChamCongForm() {
		return this.timeSheetsForm;
	}
	public DanhGiaView getDanhGiaForm2() {
		return this.danhGiaForm2;
	}
}
