package it.java.mattia.yari.gestoreBollette.model.beans;

public class Client {

	
	String clientID;
	private String name;
	private String lastName;
	
	
	/* Getter and Setter  */
	
	/* Client ID from Invoice */
	public String getClientID() {
		return clientID;
	}
	
	public void setClientID(Invoice i) {
		this.clientID = i.getClientID();
	}


	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		
		if(name != null) {
			/* min 2, max 25 char, can include '-', but not twice consecutively, must start and finish with an alphabetic letter */
			if(name.matches("(?i)(^[a-z])([a-z]*[-]?[a-z]+)*{2,25}$")) {
				this.name = name;
				return true;
				}else{
					System.out.println("'name' must be min 2 and max 25 characters; it can include '-', but not twice consecutively and must start and finish with an alphabetic letter");
					return false;
				}
			
		}else{
			System.out.println("the field 'name' cannot be empty");
			return false;
			}
	}
	


	public String getLastName() {
		return lastName;
	}


	public boolean setLastName(String lastName) {
		
		if(lastName != null) {
			/* min 2, max 25 char, can include '-', but not twice consecutively, must start and finish with an alphabetic letter */
			if(lastName.matches("(?i)(^[a-z])([a-z]*[-]?[a-z]+)*{2,25}$")) {
				this.lastName = lastName;
				return true;
				}else{
					System.out.println("'lastName' must be min 2 and max 25 characters; it can include '-', but not twice consecutively and must start and finish with an alphabetic letter");
					return false;
				}
			
		}else{
			System.out.println("the field 'lastName' cannot be empty");
			return false;
			}
		}
}