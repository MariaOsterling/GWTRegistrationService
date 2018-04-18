package eu.osterling.regapp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import eu.osterling.regapp.client.InputMessage;
import eu.osterling.regapp.client.OutputMessage;
import eu.osterling.regapp.client.RegistrationService;

public class RegistrationServiceImpl extends RemoteServiceServlet 
   implements RegistrationService{

   private static final long serialVersionUID = 1L;
   
   private ArrayList<String> list = new ArrayList<String>();

   public OutputMessage getMessage(InputMessage inputMessage) {
	   
	   OutputMessage outputMessage;
	   
	   if (inputMessage.getMessage().equals(InputMessage.ERROR)){
		   outputMessage = new OutputMessage("Error: No name is entered. Try again");
		   
	   } else if (inputMessage.getMessage().equals(InputMessage.CLEAR)){
		   list.clear();
		   outputMessage = new OutputMessage("List is cleared. List size is " + list.size());
		   
	   } else if (inputMessage.getMessage().equals(InputMessage.SHOW)){
		   //TODO handle showing OutputMessagelist better
		   outputMessage = new OutputMessage(list.toString().replace(",", "a"));
		   
	   } else {
		   //When adding the name we want to get notified what has been added.
		   //TODO: Make better list...
		   String tempString = inputMessage.getFirstName() + " " + inputMessage.getLastName();
		   list.add(tempString);

		   outputMessage = new OutputMessage(tempString + " added to list. List size is " + list.size());
	   }
	   
	   return outputMessage;
   }   
}