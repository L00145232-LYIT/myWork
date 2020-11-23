package ie.lyit.testers;

import ie.lyit.hotel.*;
import java.util.Scanner;

public class BookingTester {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
//creating a variable	
		int a, c;
		boolean good = false;
		do {

			System.out.println("Enter amount of adults(1-2)?");
			a = myObj.nextInt();

			System.out.println("Enter amount of Kids(0-3)?");
			c = myObj.nextInt();
			if ((a > 2 || a < 1) || (c > 3 || c < 0)) {

				good = false;
				System.out.println("invalid number of kids or adults; re-enter");
				System.out.println("Enter amount of adults?");
				a = myObj.nextInt();

				System.out.println("Enter amount of Kids?");
				c = myObj.nextInt();
			}
		} while (good ==true);
		Booking b1 = new Booking(a, c);
		System.out.println(b1);
	}
}