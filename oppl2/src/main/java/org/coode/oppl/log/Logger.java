package org.coode.oppl.log;

import java.util.logging.Level;

import org.coode.oppl.ConstraintSystem;
import org.coode.oppl.Renderable;

/** @author Luigi Iannone */
public class Logger {
    java.util.logging.Logger logger;

    /** @param className */
    public Logger(String className) {
        logger = java.util.logging.Logger.getLogger(className);
    }

    /** @param message */
    public void log(String message) {
        logger.log(Level.WARNING, message);
    }

    /** @param message */
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    /** @param message */
    public void fine(String message) {
        logger.log(Level.FINE, message);
    }

    /** @param message
     * @param o */
    public void log(String message, Object o) {
        logger.log(Level.WARNING, message, o);
    }

    /** @param message
     * @param o */
    public void info(String message, Object o) {
        logger.log(Level.INFO, message, o);
    }

    /** @param o */
    public void info(Object o) {
        logger.log(Level.INFO, "", o);
    }

    /** @param message
     * @param o */
    public void fine(String message, Object o) {
        logger.log(Level.FINE, message, o);
    }

    /** @param message
     * @param c
     * @param cv
     * @param o */
    public void log(String message, Renderable c, ConstraintSystem cv, Object o) {
        if (logger.isLoggable(Level.WARNING)) {
            logger.log(Level.WARNING, message + c.render(cv), o);
        }
    }

    /** @param message
     * @param c
     * @param cv
     * @param o */
    public void info(String message, Renderable c, ConstraintSystem cv, Object o) {
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, message + c.render(cv), o);
        }
    }

    /** @param c
     * @param cv */
    public void info(Renderable c, ConstraintSystem cv) {
        if (logger.isLoggable(Level.INFO)) {
            logger.log(Level.INFO, c.render(cv));
        }
    }

    /** @param message
     * @param o */
    public void fine(String message, Object... o) {
        logger.log(Level.FINE, message, o);
    }
}
