import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());

        LinkedHashMap<String, List<Double>> studentsGradeMap = new LinkedHashMap<>();
        for (int i = 1; i <= students; i++) {
            String name = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            studentsGradeMap.putIfAbsent(name, new ArrayList<>());
            studentsGradeMap.get(name).add(grade);
        }

        LinkedHashMap<String, Double> averageGradeMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentsGradeMap.entrySet()) {
            String name = entry.getKey();

            List<Double> gradesList = entry.getValue();
            double averageGrade = getAverageGrade(gradesList);

            if (averageGrade >= 4.5) {
                averageGradeMap.put(name, averageGrade);
            }
        }

        averageGradeMap.forEach((key, value) -> System.out.printf("%s -> %.2f%n", key, value));
    }
    private static double getAverageGrade(List<Double> gradesList) {
        double sumGrades = 0;
        for (double grades : gradesList) {
            sumGrades += grades;
        }
        return sumGrades / gradesList.size();
    }
}
