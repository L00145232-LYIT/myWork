package ie.lyit.serialize;
import ie.lyit.hotel.*;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class EmployeeSerializer {
private ArrayList<Employee> employee;
	
	final String FILENAME = "employee.ser";	
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct bookList ArrayList
		employee = new ArrayList<Employee>();
	}	


	public void add(){
		// Create a Book object
		Employee emp = new Employee();
//		// Read its details
		emp.read();	
		// And add it to the books ArrayList
		employee.add(emp);
	}


public void list() {
	for (Employee tmpBook : employee)
		System.out.println(tmpBook);
}

public Employee view() {
	@SuppressWarnings("resource")
	Scanner keyboard = new Scanner(System.in);
	System.out.println("ENTER NUMBER:");
	int bootToView = keyboard.nextInt();

	for (Employee tmpEmp : employee) {
		if (tmpEmp.getNo() == bootToView) {
			System.out.println(tmpEmp);
			return tmpEmp;
		}
	}
	return null;
}

public void delete() {
	Employee tmpEmp = view();
	if (tmpEmp != null)
		employee.remove(tmpEmp);
}

public void edit() {
	Employee tmpEmp = view();

	if (tmpEmp != null) {
		int index = employee.indexOf(tmpEmp);
		tmpEmp.read();
		employee.set(index, tmpEmp);
	}
}



	public void serializeBooks(){
		ObjectOutputStream os=null;
		try {
		
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			os = new ObjectOutputStream(fileStream);
				
			os.writeObject(employee);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		finally {
			try {
				os.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}


	@SuppressWarnings("unchecked")
	public void deserializeBooks(){
		ObjectInputStream is=null;
		
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			is = new ObjectInputStream(fileStream);
				
			employee = (ArrayList<Employee>)is.readObject();	
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file " + FILENAME + ".");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				is.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}
}

