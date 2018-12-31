package br.com.soc.commons;

public class DefineAction {
	
	 public static void defineAction(EventType tpEvent, String identifierType, String actionType){

	        tpEvent.setIdentifierType (identifierType);
	        tpEvent.setActionType (actionType);
	    }
}
