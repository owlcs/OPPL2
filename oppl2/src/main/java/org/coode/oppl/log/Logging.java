package org.coode.oppl.log;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

/**
 * @author Luigi Iannone
 */
public class Logging {

    private static final String LOG_FILE_PRPERTY_NAME = "org.coode.oppl.log.Logging.FileName";

    static {
        try {
            String logFileName = System.getProperty(LOG_FILE_PRPERTY_NAME);
            InputStream in = logFileName == null ? null
                : Logging.class.getClassLoader().getResourceAsStream(logFileName);
            if (in == null) {
                in = Logging.class.getResourceAsStream("/oppl-logging.properties");
            }
            if (in != null) {
                LogManager.getLogManager().readConfiguration(in);
                in.close();
            }
        } catch (SecurityException | IOException e) {
            System.out.println("No local log configuration file found");
        }
    }

    private static final Logger profiling = new Logger("org.coode.oppl.profiling");
    private static final Logger main = new Logger("org.coode.oppl");
    private static final Logger query = new Logger("org.coode.oppl.query");
    private static final Logger queryTest = new Logger("org.coode.oppl.query.test");
    private static final Logger parseTest = new Logger("org.coode.oppl.test");
    private static final Logger parse = new Logger("org.coode.oppl.test");

    /**
     * @return profiling logger
     */
    public static final Logger getProfilingLogger() {
        return profiling;
    }

    /**
     * @return main logger
     */
    public static final Logger getMainLogger() {
        return main;
    }

    /**
     * @return query logger
     */
    public static final Logger getQueryLogger() {
        return query;
    }

    /**
     * @return test logging
     */
    public static final Logger getQueryTestLogging() {
        return queryTest;
    }

    /**
     * @return parse test logging
     */
    public static final Logger getParseTestLogging() {
        return parseTest;
    }

    /**
     * @return parse logging
     */
    public static final Logger getParseLogging() {
        return parse;
    }
}
