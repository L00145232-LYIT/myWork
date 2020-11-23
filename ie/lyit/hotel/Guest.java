package ie.lyit.hotel;

public class Guest extends Person {
private String emailAddress;

	public Guest() {
		super(); //contains person
		emailAddress="";
	}

	public Guest(Name name, String phone,String email) {
		super(name,phone);
		emailAddress=email;
	}

	 public String toString(){
	      return super.toString()+","+emailAddress;
	   }
	
// equals() not overridden because sufficient to compare name & phoneNo
	
	 public void setEmailAddress(String emailAddress) {
			this.emailAddress=emailAddress;
		}
		
		public String getEmailAddress() {
			return emailAddress;
		}
		

}
