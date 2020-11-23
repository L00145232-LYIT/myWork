package ie.lyit.testers;
import ie.lyit.hotel.Room;

public class RoomTester {
	public static void main(String[] args) {
		//create room constructors for tester
		//single rooms
		Room r1 = new Room(1,0,60.00,1,true);
		Room r2 = new Room(1,0,60.00,2,true);
		Room r3 = new Room(1,0,60.00,3,true);
		Room r4 = new Room(1,0,60.00,4,true);
		Room r5 = new Room(1,0,60.00,5,true);
		//double rooms
		Room r6 = new Room(2,0,85.00,6,true);
		Room r7 = new Room(2,0,85.00,7,true);
		Room r8 = new Room(2,0,85.00,8,true);
		Room r9 = new Room(2,0,85.00,9,true);
		Room r10 = new Room(2,0,85.00,10,true);
		//family rooms
		Room r11 = new Room(2,2,120.00,11,true);
		Room r12 = new Room(2,2,120.00,12,true);
		Room r13 = new Room(2,2,120.00,13,true);
		Room r14 = new Room(2,2,120.00,14,true);
		Room r15 = new Room(2,2,120.00,15,true);
//		error room
//	Room r16 = new Room(3,3,120.00,16,false);
//		
		//display room details
		System.out.println("ROOMS IN HOTEL");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		
		System.out.println(r6);
		System.out.println(r7);
		System.out.println(r8);
		System.out.println(r9);
		System.out.println(r10);
		
		System.out.println(r11);
		System.out.println(r12);
		System.out.println(r13);
		System.out.println(r14);
		System.out.println(r15);
		
//		System.out.println(r16);
		//test if r1 and r6 is equal
		if(r1.equals(r6))
			System.out.println("The details of ROOM NUMBER "+r1.getNumber() + " is the same room as ROOM NUMBER " + r6.getNumber());
		else
			System.out.println("The details of ROOM NUMBER "+r1.getNumber() + " is NOT the same room as ROOM NUMBER " + r6.getNumber());
		//test if r1 and r5 is equal
		if(r1.equals(r5))
			System.out.println("The details of ROOM NUMBER "+r1.getNumber() + " is the same room as ROOM NUMBER " + r5.getNumber());
		else
			System.out.println("The details of ROOM NUMBER "+r1.getNumber() + " is NOT the same room as ROOM NUMBER " + r5.getNumber());
		
		
	}
	}
