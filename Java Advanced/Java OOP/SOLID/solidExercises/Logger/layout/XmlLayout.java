package solidExercises.Logger.layout;

import solidExercises.Logger.logger.Threads;

public class XmlLayout implements Layout{
    @Override
    public String format(String dateAndTime, Threads thread, String message) {
        return String.format(
                "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>%n", dateAndTime, thread, message);
    }
}
