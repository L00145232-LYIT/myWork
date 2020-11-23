package ie.lyit.hotel;
import java.io.*;
public abstract class Person implements Payable,Serializable {
	protected Name name;
	protected String phoneNo;
	
	//default constructor
	public Person() {
		name=new Name();
		phoneNo="";
	}
	
	public Person(Name nameIn, String phoneNoIn) {
		name=nameIn;
		phoneNo=phoneNoIn;
	}
	
	public String toString() {
 return name + ","+ phoneNo;
}
	@Override
	public boolean equals(Object obj) {
		   Person pObject;
		      if(obj instanceof Person)
		         pObject =(Person)obj;
		      else
		         return false;  
		   
		      return name.equals(pObject.name)
		         &&  phoneNo.equals(pObject.phoneNo);
		        
		   }

	public void setName(Name name) {
		this.name=name;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public Name getName() {
		return name;
	}
	
	public void setPhoneNo(String phoneNoIn) {
		phoneNoIn=phoneNo;
	}
}
