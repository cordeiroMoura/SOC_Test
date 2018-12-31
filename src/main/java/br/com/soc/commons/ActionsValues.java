package br.com.soc.commons;

public class ActionsValues {
	
	public static void atributtesActions(GlobalVar varGlobals, String identifier, String op1,String op2,
		    String op3, String message){

		varGlobals.setIdentifier (identifier);
		varGlobals.setOp1 (op1);
		varGlobals.setOp2 (op2);
		varGlobals.setOp3 (op3);
		varGlobals.setMessage (message);
	}
}
