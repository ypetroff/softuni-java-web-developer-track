package solidExercises.Logger.layout;

import solidExercises.Logger.logger.Threads;

public class SimpleLayout implements Layout {

    @Override
    public String format(String dateAndTime, Threads thread, String message) {
        return String.format("%s - %s - %s", dateAndTime, thread, message);
    }
}

