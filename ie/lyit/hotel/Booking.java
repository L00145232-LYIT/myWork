package ie.lyit.hotel;

public class Booking {
private Date checkInDate;
private int noNights;
private int noAdults;
private int noKids;
private Guest guestDetails;
private Room roomAllocated;
private double totalPrice;
private int bookingNo;
private static int nextUniqueBookingNumber=120000;

public Booking(int noAdults,int noKids) {
	checkInDate=new Date(06,11,2020);
	this.noNights=2;
	this.noAdults=noAdults;
	this.noKids=noKids;
	guestDetails=new Guest(new Name("Mr","Joe","Cole"),"0861781234","joecole@gmail.com");
	nextUniqueBookingNumber=nextUniqueBookingNumber+1;
}

public String toString() {
	return 	"HOTEL BOOKINGS\n"+
			"BOOKING : "+this.nextUniqueBookingNumber+
			"==>"+this.guestDetails.name+
			" from "+this.checkInDate+
			" for "+this.noNights+" nights";
			
		
}

@Override
public boolean equals(Object obj){
    Booking bObject;
    if(obj instanceof Booking)
       bObject =(Booking)obj;
    else
       return false;  
 
    return this.checkInDate == bObject.checkInDate
       &&  this.noNights==bObject.noNights
       &&  this.noAdults==bObject.noAdults
       &&  this.noKids==bObject.noKids
       &&  this.guestDetails.equals(bObject.guestDetails);
 }

}
