package lecture.four.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggerConfig {
    private static void configureLogging() {
        Logger classALogging = Logger.getLogger("org.stepic.java.logging.ClassA");
        classALogging.setLevel(Level.ALL);

        Logger classBLogging = Logger.getLogger("org.stepic.java.logging.ClassB");
        classBLogging.setLevel(Level.WARNING);

        Logger logger = Logger.getLogger("org.stepic.java");
        logger.setLevel(Level.ALL);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        XMLFormatter xmlFormatter = new XMLFormatter();
        consoleHandler.setFormatter(xmlFormatter);
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }
}
