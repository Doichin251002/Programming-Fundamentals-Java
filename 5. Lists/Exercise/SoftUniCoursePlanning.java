import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> scheduleLessons = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scan.nextLine();
        while (!command.equals("course start")) {
            String operation = command.split(":")[0];
            String lessonTitle1 = command.split(":")[1];

            if (scheduleLessons.contains(lessonTitle1)) {
                switch (operation) {
                    case "Remove":
                        scheduleLessons.remove(lessonTitle1);
                        scheduleLessons.remove(lessonTitle1 + "-Exercise");
                        break;
                    case "Swap":
                        String lessonTitle2 = command.split(":")[2];
                        int indexLesson1 = scheduleLessons.indexOf(lessonTitle1);
                        int indexLesson2 = scheduleLessons.indexOf(lessonTitle2);
                        Collections.swap(scheduleLessons, indexLesson1, indexLesson2);

                        if (scheduleLessons.contains(lessonTitle1 + "-Exercise")) {
                            swapExercise(scheduleLessons, lessonTitle1, indexLesson2);
                        } else if (scheduleLessons.contains(lessonTitle2 + "-Exercise")) {
                            swapExercise(scheduleLessons, lessonTitle2, indexLesson1);
                        }
                        break;
                    case "Exercise":
                        int indexLesson = scheduleLessons.indexOf(lessonTitle1) + 1;
                        scheduleLessons.add(indexLesson, lessonTitle1 + "-Exercise");
                        break;
                }
            } else {
                switch (operation) {
                    case "Add":
                        scheduleLessons.add(lessonTitle1);
                        break;
                    case "Insert":
                        int index = Integer.parseInt(command.split(":")[2]);
                        scheduleLessons.add(index, lessonTitle1);
                        break;
                    case "Exercise":
                        scheduleLessons.add(lessonTitle1);
                        scheduleLessons.add(lessonTitle1 + "-Exercise");
                        break;
                }
            }
            command = scan.nextLine();
        }

        for (int i = 1; i <= scheduleLessons.size(); i++) {
            System.out.printf("%d.%s%n", i, scheduleLessons.get(i - 1));
        }
    }

    private static void swapExercise(List<String> scheduleLessons, String lessonTitle1, int indexLesson2) {
        int indexLesson1;
        int removedIndexExercise = scheduleLessons.indexOf(lessonTitle1 + "-Exercise");
        lessonTitle1 = scheduleLessons.remove(removedIndexExercise);
        indexLesson1 = indexLesson2 + 1;
        scheduleLessons.add(indexLesson1, lessonTitle1);
    }
}
