package fr.fiegel.conjugueur.commun.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.fiegel.conjugueur.commun.enums.ELog;

public class Logger {

	private  boolean printDebug = false;
	private  String appName = "";
	private  String className = "Logger";
	private static Logger instance=null;

	private Logger(String appName){
		this.appName=appName;
	}
	
	public static void create(String appName){
		Logger.instance = new Logger(appName);
	}
	
	public static Logger get(){
		return Logger.instance;
	}
	
	/**
	 * A simple message logging function. The message type gets printed before
	 * the actual message.
	 * 
	 * @param msgType
	 *            the message type
	 * @param msg
	 *            the message to display
	 */
	 public void print(ELog msgType, String msg) {
		print("", msgType, msg);
	}

	 public void print(Object classe, ELog msgType, String msg) {
		print(classe.getClass().getSimpleName(), msgType, msg);
	}

	 public void print(String classe, ELog msgType, String msg) {
		// If we're ignoring debug messages and this one is a debug
		// message, return.
		if (!printDebug && msgType==ELog.DEBUG) {
			return;
		}

		String finalMessage = getCurrentTime()+"[".concat(appName);

		if (!classe.equals("")) {
			if(!appName.equals("")){
				finalMessage = finalMessage.concat(" / ");
			}
			finalMessage = finalMessage.concat(classe);
		}

		if (!msgType.equals("")) {
			finalMessage = finalMessage.concat("] [").concat(msgType.name());
		}

		finalMessage = finalMessage.concat("]\t ").concat(msg);

		System.out.println(finalMessage);

	}

	/**
	 * Sets how much debug output to print ('true' prints debug and error
	 * messages; 'false' prints only error messages).
	 * 
	 * @param enablePrintDebug
	 *            <code>true</code> to print debug output
	 */
	 public void setPrintDebug(boolean enablePrintDebug) {
		if (enablePrintDebug == printDebug)
			return;
		printDebug = enablePrintDebug;
		if (enablePrintDebug) {
			print(className, ELog.INFO, "Debug enabled");
		} else
			print(className, ELog.INFO, "Debug disabled");
	}
	
	private static  String getCurrentTime(){
		SimpleDateFormat format = new SimpleDateFormat("[H:m:s.S]");
		Date date = new Date();
		return format.format(date);
	}

}
