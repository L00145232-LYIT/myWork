package ie.lyit.hotel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends Person implements Payable {
//	private Date dob;
//	private Date startDate;
	private double salary;
	private int number;

	private static int nextNumber = 1000;
	private final double MAX_SALARY = 150000.00;

	public Employee() {
		super();
//		dob = new Date();
//		startDate = new Date();
		salary = 0.00;
		number = nextNumber++;
	}

// Overloaded Initialization Constructor
	// Called when object is created like this ==>
	// Name name = Name("Mr","Joe","Doe");
	// Employee e2 = new Employee(name,"087 1234567",
	// new Date(25,12,1970),new Date(10,11,2009),55000);
	public Employee(Name name, String phoneNumber,double salary) {
		// Call super class constructor, passing fields required by Person
		super(name, phoneNumber);
//		this.dob = dob;
//		this.startDate = startDate;
		this.salary = salary;
		this.number = nextNumber++;
	}

	@Override

	public String toString() {
		return salary + "" + number;
	}

//	public void setDOB(Date dob) {
//		this.dob = dob;
//	}
//
//	public Date getDOB() {
//		return dob;
//	}
//
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//
//	public Date getStartDate() {
//		return startDate;
//	}

	public void setSalary(double salary) {
		if (salary < 0)
			throw new IllegalArgumentException("INVALID NUMBER; salary can not have less than 0");
		else
			this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public int getNo() {
		return number;
	}

	public int setNo(int number) {
		if (number < 1000)
			throw new IllegalArgumentException("INVALID NUMBER; must be more than 1000");
		else
			return this.number = number;
	}

	public double calculatePay(double taxPerc) {
		// TODO Auto-generated method stub
		double pay = salary / 12;
		pay -= (pay * taxPerc / 1000);
		return pay;
	}

	public double incrementPay(double incPerc) {
		// TODO Auto-generated method stub
		salary += incPerc;
		if (salary > MAX_SALARY)
			salary = MAX_SALARY;

		return salary;
	}

// read() - To read a book from the user	
	public void read() {
		JTextField txtNo = new JTextField();
		txtNo.setText("" + this.getNo());
		txtNo.requestFocus();
		JTextField txtFName = new JTextField();
		JTextField txtSName = new JTextField();
		JTextField txtTitle = new JTextField();
		JTextField txtPhoneNo = new JTextField();
		JTextField txtSalary = new JTextField();
		

		Object[] message = { "NUMBER: ", txtNo,

		"FIRST NAME:", txtFName, "SURNAME:", txtSName, "TITLE:", txtTitle,"SALARY:", txtSalary, "PHONE NO:", txtPhoneNo };

		int option = JOptionPane.showConfirmDialog(null, message, "Enter user details", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			name.setTitle(txtTitle.getText());
			name.setFirstName(txtFName.getText());
			name.setTitle(txtSName.getText());
			this.phoneNo = txtSalary.getText();
			this.salary = Double.parseDouble(txtSalary.getText());
			this.number = Integer.parseInt(txtNo.getText());

		}
	}

}
