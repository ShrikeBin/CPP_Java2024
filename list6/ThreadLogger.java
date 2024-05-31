import java.util.logging.Level;

public class ThreadLogger
{
    private ThreadLogger() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of a static class ThreadController");
    }

    public static void logStart(Thread thread)
    {
        MyLogger.logger.log(Level.FINE,"Start: " + thread.threadId());
    }

    public static void logEnd(Thread thread)
    {
        MyLogger.logger.log(Level.FINE,"End: " + thread.threadId());
    }
}
