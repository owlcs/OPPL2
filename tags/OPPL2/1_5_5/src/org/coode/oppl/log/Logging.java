/**
 * 
 */
package org.coode.oppl.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author Luigi Iannone
 * 
 */
public class Logging {
	public static final String LOG_FILE_PRPERTY_NAME = "org.coode.oppl.log.Logging.FileName";
	static {
		try {
			String logFileName = System.getProperty(LOG_FILE_PRPERTY_NAME);
			InputStream in = logFileName == null ? null
					: Logging.class.getClassLoader().getResourceAsStream(logFileName);
			LogManager.getLogManager().readConfiguration(
					in == null ? Logging.class.getResourceAsStream("oppl-logging.properties") : in);
		} catch (SecurityException e) {
			getMainLogger().log(Level.WARNING, "No local log coonfiguration file found");
		} catch (IOException e) {
			getMainLogger().log(Level.WARNING, "No local log coonfiguration file found");
		}
	}

	public static final Logger getProfilingLogger() {
		return Logger.getLogger("org.coode.oppl.profiling");
	}

	public static final Logger getMainLogger() {
		return Logger.getLogger("org.coode.oppl");
	}

	public static final Logger getQueryLogger() {
		return Logger.getLogger("org.coode.oppl.query");
	}

	public static final Logger getQueryTestLogging() {
		return Logger.getLogger("org.coode.oppl.query.test");
	}

	public static final Logger getParseTestLogging() {
		return Logger.getLogger("org.coode.oppl.test");
	}
}
