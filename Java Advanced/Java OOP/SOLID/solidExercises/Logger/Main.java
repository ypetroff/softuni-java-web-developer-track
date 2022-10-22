package solidExercises.Logger;

import solidExercises.Logger.appender.Appender;
import solidExercises.Logger.appender.ConsoleAppender;
import solidExercises.Logger.appender.FileAppender;
import solidExercises.Logger.layout.Layout;
import solidExercises.Logger.layout.SimpleLayout;
import solidExercises.Logger.layout.XmlLayout;
import solidExercises.Logger.logger.Logger;
import solidExercises.Logger.logger.MessageLogger;
import solidExercises.Logger.logger.Threads;
import solidExercises.Logger.utils.File;
import solidExercises.Logger.utils.LogFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int appendersCount = Integer.parseInt(scanner.nextLine());

        Map<Appender, Threads> appenderLogLevelMap = new LinkedHashMap<>();

        while (appendersCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String appenderType = tokens[0];
            String layoutType = tokens[1];
            Threads logLevel = tokens.length == 3
                    ? Threads.valueOf(tokens[2])
                    : Threads.INFO;

            Layout layout = createLayout(layoutType);
            Appender appender = createAppender(appenderType, layout);

            appenderLogLevelMap.put(appender, logLevel);
        }

        Logger logger = new MessageLogger(appenderLogLevelMap);

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            String[] tokens = line.split("\\|");

            Threads logLevel = Threads.valueOf(tokens[0]);

            String timeStamp = tokens[1];
            String message = tokens[2];

            switch (logLevel) {
                case INFO -> logger.logInfo(timeStamp, message);
                case WARNING -> logger.logWarning(timeStamp, message);
                case ERROR -> logger.logError(timeStamp, message);
                case CRITICAL -> logger.logCritical(timeStamp, message);
                case FATAL -> logger.logFatal(timeStamp, message);
            }

            line = scanner.nextLine();
        }

        System.out.println(logger.toString());
    }

    private static Appender createAppender(String appenderType, Layout layout) {
        return switch (appenderType) {
            case "ConsoleAppender" -> new ConsoleAppender(layout);
            case "FileAppender" -> new FileAppender(layout, new LogFile());
        //    case "XmlAppender" -> new XmlAppender(layout);
            default -> throw new IllegalStateException("Unexpected appender type: " + appenderType);
        };
    }

    private static Layout createLayout(String layoutType) {
        return layoutType.equals("SimpleLayout")
                ? new SimpleLayout() : new XmlLayout();
    }
}

