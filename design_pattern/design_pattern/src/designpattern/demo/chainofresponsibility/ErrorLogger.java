package designpattern.demo.chainofresponsibility;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		this.level = level;
	}
	@Override
	protected void write(String message) {
		System.out.println(String.format("ErrorLogger[message=%s]", message));
	}

}
