package solidExercises.Logger.utils;

public class LogFile implements File{

    private static String DEFAULT_FILE_NAME = "default.txt";

    StringBuilder collectedMessages;
    String fileName;
    private int size;

    public LogFile() {
        this(DEFAULT_FILE_NAME);

    }

    public LogFile(String fileName) {
        this.collectedMessages = new StringBuilder();
        this.size = 0;
        this.fileName = fileName;

    }


    @Override
    public void write(String line) {
        collectedMessages.append(line).append(System.lineSeparator());
    }

    @Override
    public int size() {
        return collectedMessages.chars().filter(Character::isAlphabetic).sum();
    }

    @Override
    public String getFile() {
        return collectedMessages.toString();
    }
}
