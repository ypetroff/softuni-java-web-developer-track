package solidExercises.Logger.appender;

import solidExercises.Logger.layout.Layout;
import solidExercises.Logger.logger.Threads;
import solidExercises.Logger.utils.File;


public class FileAppender extends BaseAppender {


    private File file;

    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
    }

    @Override
    public void append(String dateAndTime, Threads thread, String message) {
        counter++;
        file.write(getLayout().format(dateAndTime, thread, message));
    }

    public File getFile() {
        return file;
    }

}
