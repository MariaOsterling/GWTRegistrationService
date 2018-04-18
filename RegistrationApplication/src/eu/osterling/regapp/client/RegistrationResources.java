package eu.osterling.regapp.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface RegistrationResources extends ClientBundle {
	   /**
	   * Sample CssResource.
	   */
	   public interface MyCss extends CssResource {
	      String blackText();

	      String button2();

	      String box();

	      String background();
	      
	   }

	   @Source("Registration.css")
	   MyCss style();
	}
