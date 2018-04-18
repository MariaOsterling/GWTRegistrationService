package eu.osterling.regapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationServiceAsync {

	void getMessage(InputMessage input, AsyncCallback<OutputMessage> callback);
}