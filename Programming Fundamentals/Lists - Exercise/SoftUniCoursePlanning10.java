import java.util.*;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> courseSchedule = Arrays.stream(scanner.nextLine().trim().replaceAll("\\s+", " ").split(", "))
                .collect(Collectors.toList());
        List<String> coursesWithExercises = new ArrayList<>();

        String action = scanner.nextLine();

        while (!action.equals("course start")) {
            String[] command = action.split(":");
            String currentCommand = command[0];
            String lessonTitle = command[1];

            boolean lessonExists = findLesson(courseSchedule, lessonTitle);

            switch (currentCommand) {
                case "Add":
                    if (!lessonExists) {
                        addLesson(courseSchedule, lessonTitle);
                    }
                    break;
                case "Insert":
                    if (!lessonExists) {
                        int index = Integer.parseInt(command[2]);
                        insertLesson(courseSchedule, lessonTitle, index);
                    }
                    break;
                case "Remove":
                    if (lessonExists) {
                        removeLesson(courseSchedule, lessonTitle, coursesWithExercises);
                    }
                    break;
                case "Swap":
                    String swapLesson = command[2];
                    boolean swapLessonExists = findLesson(courseSchedule, swapLesson);
                    if (lessonExists && swapLessonExists) {
                        swapLessons(courseSchedule, lessonTitle, swapLesson, coursesWithExercises);
                    }
                    break;
                case "Exercise":
                    if (lessonExists) {
                        boolean hasExercise = findExercise(coursesWithExercises, lessonTitle);
                        if (!hasExercise) {
                            addExercise(courseSchedule, lessonTitle, coursesWithExercises);
                        }
                    } else {
                        addLesson(courseSchedule, lessonTitle);
                        addExercise(courseSchedule, lessonTitle, coursesWithExercises);
                    }
                    break;
            }
            action = scanner.nextLine();
        }

        for (int i = 0; i < courseSchedule.size(); i++) {
            System.out.printf("%d.%s%n",i + 1, courseSchedule.get(i));
        }
    }


    private static boolean findLesson(List<String> courseSchedule, String lessonTitle) {
        return courseSchedule.contains(lessonTitle);
    }

    private static void addLesson(List<String> courseSchedule, String lessonTitle) {
        courseSchedule.add(lessonTitle);
    }

    private static void insertLesson(List<String> courseSchedule, String lessonTitle, int index) {
      if (index >= 0 && index < courseSchedule.size()) {
          courseSchedule.add(index, lessonTitle);
       }

    }

    private static void removeLesson(List<String> courseSchedule, String lessonTitle, List<String> coursesWithExercises) {
        boolean hasExercise = findExercise(coursesWithExercises, lessonTitle);
        if (hasExercise) {
            courseSchedule.remove(courseSchedule.indexOf(lessonTitle) + 1);
        }
        courseSchedule.remove(lessonTitle);

    }

    private static void swapLessons(List<String> courseSchedule, String lessonTitle, String swapLesson, List<String> coursesWithExercises) {

        boolean lessonHasExercise = findExercise(coursesWithExercises, lessonTitle);
        boolean swapHasExercise = findExercise(coursesWithExercises, swapLesson);
        Collections.swap(courseSchedule, courseSchedule.indexOf(lessonTitle), courseSchedule.indexOf(swapLesson));

        if (lessonHasExercise || swapHasExercise) {

            swapExercisesSwappedLessons(courseSchedule, lessonTitle, swapLesson, lessonHasExercise);
            swapExercisesSwappedLessons(courseSchedule, swapLesson, lessonTitle, swapHasExercise);
        }
    }

    private static boolean findExercise(List<String> coursesWithExercises, String lessonTitle) {
        return coursesWithExercises.contains(lessonTitle);
    }

    private static void addExercise(List<String> courseSchedule, String lessonTitle, List<String> coursesWithExercises) {
        String exerciseName = lessonTitle + "-Exercise";
        if (courseSchedule.indexOf(lessonTitle) + 1 == courseSchedule.size()) {
            courseSchedule.add(exerciseName);
        } else {
            courseSchedule.add(courseSchedule.indexOf(lessonTitle) + 1, exerciseName);
        }

        coursesWithExercises.add(lessonTitle);
    }

    private static void swapExercisesSwappedLessons(List<String> courseSchedule, String lessonTitle, String swapLesson, boolean lessonHasExercise) {
        if (lessonHasExercise) {
            if(courseSchedule.indexOf(lessonTitle) + 1 ==  courseSchedule.size()) {
                courseSchedule.add(courseSchedule.get(courseSchedule.indexOf(swapLesson) + 1));
            } else {
                courseSchedule.add(courseSchedule.indexOf(lessonTitle) + 1, courseSchedule.get(courseSchedule.indexOf(swapLesson) + 1));
            }

            courseSchedule.remove(courseSchedule.indexOf(swapLesson) + 1);
        }
    }
}
