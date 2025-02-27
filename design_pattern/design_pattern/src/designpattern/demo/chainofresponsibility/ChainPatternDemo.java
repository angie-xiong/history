package designpattern.demo.chainofresponsibility;

public class ChainPatternDemo {

	public static void main(String[] args) {
		AbstractLogger abstractLogger = getChainOfLogger();
		abstractLogger.logMessage(AbstractLogger.ERROR, "This is Error!");
		abstractLogger.logMessage(AbstractLogger.INFO, "This is Info!");
		abstractLogger.logMessage(AbstractLogger.DEBUG, "This is Debug!");
	}

	private static AbstractLogger getChainOfLogger() {
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.DEBUG);
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.INFO);
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return errorLogger;
	}

}
