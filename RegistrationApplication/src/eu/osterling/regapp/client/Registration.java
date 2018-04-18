package eu.osterling.regapp.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Registration extends Composite {
	private static RegistrationUiBinder uiBinder = GWT.create(RegistrationUiBinder.class);

	private RegistrationServiceAsync registrationService = 
			GWT.create(RegistrationService.class);

	/**
	 * Responsible for handling the reply from the server
	 */
	private class RegistrationCallBack implements AsyncCallback<OutputMessage> {
		@Override
		public void onFailure(Throwable caught) {
			/* server side error occured */
			Window.alert("Unable to obtain server response: " 
					+ caught.getMessage());	
		}
		@Override
		public void onSuccess(OutputMessage resultFromServer) {
			/* server returned result, show user the message */
			//TODO Make better handling of the different scenarios
			String s = resultFromServer.getMessage();
			
			Window.alert(resultFromServer.getMessage());
		}	   
	}
	/*
	 * @UiTemplate is not mandatory but allows multiple XML templates
	 * to be used for the same widget. 
	 * Default file loaded will be <class-name>.ui.xml
	 */
	@UiTemplate("Registration.ui.xml")
	interface RegistrationUiBinder extends UiBinder<Widget, Registration> {
	}

	@UiField(provided = true)
	final RegistrationResources res;

	public Registration() {
		this.res = GWT.create(RegistrationResources.class);
		res.style().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	TextBox firstNameTxt;

	@UiField
	TextBox lastNameTxt;

	@UiField
	Button clearListButton;

	@UiField
	Button showListButton;

	@UiField
	Button submitButton;

	@UiHandler("clearListButton")
	void doClickClearButton(ClickEvent event) {
		//1. Make remote call to server to get the applicable message:
		registrationService.getMessage(new InputMessage(InputMessage.CLEAR), new RegistrationCallBack());

		//2. Clear potential entry from gui:
		firstNameTxt.setText("");
		lastNameTxt.setText("");
	}

	@UiHandler("showListButton")
	void doClickShowButton(ClickEvent event) {
		//1. Make remote call to server to get the applicable message:
		registrationService.getMessage(new InputMessage(InputMessage.SHOW), new RegistrationCallBack());
		
		//2. Clear potential entry from gui:
		firstNameTxt.setText("");
		lastNameTxt.setText("");
	}

	@UiHandler("submitButton")
	void doClickSubmitButton(ClickEvent event) {
		//1. Make remote call to server to get the applicable message:
		InputMessage messageToServer;
		if ((firstNameTxt.getValue().length() == 0) || (lastNameTxt.getValue().length() == 0)) {
			messageToServer = new InputMessage(InputMessage.ERROR);
		} else {
			messageToServer = new InputMessage(firstNameTxt.getValue(), lastNameTxt.getValue());
		}
		registrationService.getMessage(messageToServer, new RegistrationCallBack());
		
		//2. Clear current entry from gui:
		firstNameTxt.setText("");
		lastNameTxt.setText("");
	}
}
