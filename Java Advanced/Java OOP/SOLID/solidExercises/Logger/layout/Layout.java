package solidExercises.Logger.layout;

import solidExercises.Logger.logger.Threads;

public interface Layout {

    public String format(String dateAndTime, Threads thread, String message);
}
