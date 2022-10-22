package solidExercises.Logger.appender;

import solidExercises.Logger.layout.Layout;
import solidExercises.Logger.logger.Threads;

public abstract class BaseAppender implements Appender{

    private Layout layout;
    protected int counter;

    protected  BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

    @Override
    public int getMessagesCount() {
        return counter;
    }

    @Override
    public void append(String dateAndTime, Threads thread, String message) {
        counter++;
    }
}
