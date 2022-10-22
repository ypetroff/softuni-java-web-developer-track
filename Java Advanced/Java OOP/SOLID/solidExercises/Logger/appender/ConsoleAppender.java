package solidExercises.Logger.appender;

import solidExercises.Logger.layout.Layout;
import solidExercises.Logger.logger.Threads;

public class ConsoleAppender extends BaseAppender{



    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateAndTime, Threads thread, String message) {
        counter++;
        System.out.println(getLayout().format(dateAndTime, thread, message));
    }

}
