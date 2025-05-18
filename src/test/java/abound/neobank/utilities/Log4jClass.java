package abound.neobank.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jClass 
{
	public static void fn_logger_trace(String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.info(message);
	}

	public static void fn_logger_debug(String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.debug(message);
		// test.log(Status.INFO, message);
	}

	public static void fn_logger_info(String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.info(message);

		//updateTestStepsInExtentReport(message, "INFO");	
		// test.log(Status.INFO, message);
		// SDMS_Driver.extent.flush();
	}

	public static void fn_logger_pass(String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.info(message);

		// test.log(Status.PASS, message);
		// SDMS_Driver.extent.flush();
	}

	public static void fn_logger_fail(String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.info(message);
		
	}

	public static void fn_logger_warn( String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.info(message);

	}

	public static void fn_logger_error( String message) {
		Logger logger1 = Logger.getLogger("Generic_Methods");
		PropertyConfigurator.configure("Log4j.properties");
		logger1.info(message);
	}

}
