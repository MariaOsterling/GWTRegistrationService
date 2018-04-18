package eu.osterling.regapp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registration")
public interface RegistrationService extends RemoteService {
   OutputMessage getMessage(InputMessage input);
}