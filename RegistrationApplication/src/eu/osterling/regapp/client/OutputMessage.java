package eu.osterling.regapp.client;

import java.io.Serializable;

public class OutputMessage implements Serializable {
 
//	public static final String SHOW = "SHOW";
//	public static final String CLEAR = "CLEAR";
//	public static final String ERROR = "ERROR";

	private static final long serialVersionUID = 1L;
//	private String firstName;
//	private String lastName;
	private String message;
	
	public OutputMessage(){};
	
	public OutputMessage(String message){
//		this.firstName = "";
//		this.lastName = "";
		this.message = message;
	};
	
//	public OutputMessage(String firstName, String lastName){
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.message = "";
//	};

	public String getMessage() {
		return message;
	}
//	
//	public String getFirstName() {
//		return firstName;
//	}
//	
//	public String getLastName() {
//		return lastName;
//	}
//	
//	public String getTotalMessage() {
//		return firstName + lastName + message;
//	}
	
}