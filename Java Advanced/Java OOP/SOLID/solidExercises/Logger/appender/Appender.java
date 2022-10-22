package solidExercises.Logger.appender;

import solidExercises.Logger.layout.Layout;
import solidExercises.Logger.logger.Threads;

public interface Appender {

     void append(String dateAndTime, Threads thread, String message);
     Layout getLayout();
     int getMessagesCount();
}
