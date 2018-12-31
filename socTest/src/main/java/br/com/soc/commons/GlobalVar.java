package br.com.soc.commons;

public class GlobalVar {
	
	public String op1, op2, op3;
	public String pathEvidence;
	public String message;
	public String identifier;
	public String validaResultadoObtido;
	public String id;
	public String elementType;
	public String result;
	public String captureText;
    public boolean dynamicsElement = true;
	
	public String getCaptureText() {
		return captureText;
	}

	public void setCaptureText(String captureText) {
		this.captureText = captureText;
	}

	public boolean isDynamicsElement() {
		return dynamicsElement;
	}

	public void setDynamicsElement(boolean dynamicsElement) {
		this.dynamicsElement = dynamicsElement;
	}	

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getPathEvidence() {
		return pathEvidence;
	}

	public void setPathEvidence(String pathEvidence) {
		this.pathEvidence = pathEvidence;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getValidaResultadoObtido() {
		return validaResultadoObtido;
	}

	public void setValidaResultadoObtido(String validaResultadoObtido) {
		this.validaResultadoObtido = validaResultadoObtido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
