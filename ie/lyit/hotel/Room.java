package ie.lyit.hotel;

public class Room {
private int maxAdults;
private int maxKids;
private double pricePerNight;
private boolean allocated;
private int number;

public Room(int maxAdults,int maxKids,double pricePerNight, int number,boolean allocated) {
	this.maxAdults=maxAdults;
	this.maxKids=maxKids;
	this.pricePerNight=pricePerNight;
	this.number=number;
	this.allocated=allocated;
}

public String toString() {
	return "ROOM "+getNumber()+ "[ADULTS: "+this.maxAdults+",KIDS :"+this.maxKids+",PRICE: "+this.pricePerNight+",Allocated: "+this.allocated;
}

@Override

public boolean equals(Object obj){
    Room rObject;
    if(obj instanceof Room)
       rObject =(Room)obj;
    else
       return false;  
 
    return this.maxAdults == rObject.maxAdults
       &&  this.maxKids==rObject.maxKids
       &&  this.pricePerNight == rObject.pricePerNight;
 }
public void setMaxAdults(int maxAdults) {
	if(maxAdults < 0 || maxAdults > 2)
		throw new IllegalArgumentException("INVALID NUMBER; ONLY CAN HAVE MAX 2 ADULTS OR MIN 1 ADULT IN A ROOM");
	else {
	this.maxAdults=maxAdults;
	}
}

public void setMaxKids(int maxKids) {
	if((maxKids < 0|| maxKids > 3)&(maxAdults < 0 || maxAdults > 2))
		throw new IllegalArgumentException("INVALID NUMBER; MUST CONTAIN MAX 3 KIDS, OR MINIMUM 1 ADULT IN ROOM");
	else {
	this.maxKids=maxKids;
	}
}

public void setPricePerNight(double pricePerNight) {
	this.pricePerNight=pricePerNight;
}

public void setNumber(int number) {
	this.number=number;
}



public int getAdults() {
	return this.maxAdults;
}

public int getKids() {
	return this.maxKids;
}

public int getNumber() {
	return this.number;
}

public double getPrice() {
	return this.pricePerNight;
}
}
