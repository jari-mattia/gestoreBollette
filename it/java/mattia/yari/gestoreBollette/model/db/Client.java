package it.java.mattia.yari.gestoreBollette.model.db;

public class Client {

	
	private String clientID;
	private String name;
	private String lastName;
	
	
	/* every fields must be not null */
	public Client(String clientID, String name, String lastName) {
		
		this.clientID = clientID;
		this.name = name;
		this.lastName = lastName;
	}

	/* Getter and Setter  */
	
	public String getClientID() {
		return clientID;
	}


	public boolean setClientID(String clientID) {
		
		if(clientID != null) {
			this.clientID = clientID;
			return true;
		}else{
			System.out.println("the field 'Client ID' cannpt be empty");
			return false;
			}
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
			System.out.println("the field 'name' cannpt be empty");
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
			System.out.println("the field 'lastName' cannpt be empty");
			return false;
			}
		}
}