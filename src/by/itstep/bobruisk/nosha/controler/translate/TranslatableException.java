package by.itstep.bobruisk.nosha.controler.translate;

@SuppressWarnings("serial")
public class TranslatableException extends Exception {
	private Throwable couse;
	private String exception;

	public TranslatableException(String exception, Throwable couse) {
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
