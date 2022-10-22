package solidExercises.Logger.logger;

import solidExercises.Logger.appender.Appender;
import solidExercises.Logger.appender.FileAppender;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MessageLogger implements Logger{

    private Map<Appender, Threads> appenderWithThreadLevel;

    public MessageLogger(Map<Appender, Threads> appenderWithThreadLevel) {
        this.appenderWithThreadLevel = appenderWithThreadLevel;
    }

    @Override
    public void logInfo(String dateAndTime, String message) {
        logAllAppenders(dateAndTime, Threads.INFO, message);
    }

    @Override
    public void logWarning(String dateAndTime, String message) {
        logAllAppenders(dateAndTime, Threads.WARNING, message);
    }

    @Override
    public void logError(String dateAndTime, String message) {
        logAllAppenders(dateAndTime, Threads.ERROR, message);
    }

    @Override
    public void logCritical(String dateAndTime, String message) {
        logAllAppenders(dateAndTime, Threads.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateAndTime, String message) {
        logAllAppenders(dateAndTime, Threads.FATAL, message);
    }

    private void logAllAppenders(String dateAndTime, Threads thread, String message) {
        for (var entry : appenderWithThreadLevel.entrySet()) {

            Appender appender = entry.getKey();
            Threads appenderThread = entry.getValue();

            if(appenderThread.ordinal() <= thread.ordinal()) {
                appender.append(dateAndTime, thread, message);
            }
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Logger info").append(System.lineSeparator());

        for (var entry : appenderWithThreadLevel.entrySet()) {
            Appender appender = entry.getKey();
            Threads thread = entry.getValue();
            sb.append(String.format("Appender type: %s, Layout type: %s,",
                    appender.getClass().getSimpleName(), appender.getLayout().getClass().getSimpleName()))
                    .append(String.format("Report level: %s", thread.toString()))
                    .append(String.format("Messages appended: %d", appender.getMessagesCount()));

            if(appender instanceof FileAppender) {
                sb.append(String.format(", File size: %d", ((FileAppender)appender).getFile().size()));
            }
            sb.append(System.lineSeparator());
        }
       return sb.toString().trim();
    }
}
