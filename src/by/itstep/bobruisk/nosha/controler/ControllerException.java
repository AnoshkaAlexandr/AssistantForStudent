package by.itstep.bobruisk.nosha.controler;



@SuppressWarnings("serial")
public class ControllerException extends RuntimeException{
private Throwable couse;
private String exception;
public ControllerException(String exception, Throwable couse) {
	this.couse = couse;
	this.exception = exception;
}
public Throwable getCouse() {
	return couse;
}
public String getException() {
	return exception;
}


}
