package ie.lyit.testers;

import ie.lyit.serialize.*;
import ie.lyit.hotel.*;
//import java.util.*;

public class EmployeeSerializerTester {
	public static void main(String[] args) {
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();
		Menu menu = new Menu();

		employeeSerializer.deserializeBooks();
		do {
			menu.display();
			menu.readOption();
			switch (menu.getOption()) {
			case 1:
				employeeSerializer.add();
				break;
			case 2:
				employeeSerializer.list();
				break;
			case 3:
				employeeSerializer.view();
				break;
			case 4:
				employeeSerializer.edit();
				break;
			case 5:
				employeeSerializer.delete();
				break;
			case 6:
				break;
			}
		} while (menu.getOption() != 6);
		employeeSerializer.serializeBooks();
	}

}
