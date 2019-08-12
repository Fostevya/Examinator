package utility;

import exam.Exam;
import trainee.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamHelper {

    // Процедура для вывода результатов тестирования в файл
    public static void examResultsToFile(Exam exam) {
        String textFileExtension = ".txt";
        ArrayList<String> resultsToWrite = exam.getExamResults();
        try (FileWriter writer = new FileWriter(exam.getExamDiscipline() + textFileExtension, false)) {
            writer.write(exam.getExamInfo() + System.lineSeparator());
            resultsToWrite.stream().map(x -> x + System.lineSeparator()).forEach(str -> {
                try {
                    writer.write(str);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
            writer.flush();
            System.out.println("Результаты записаны в файл: " + exam.getExamDiscipline() + textFileExtension);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Процедура для генерации данных о студентах
    public static void setRandomStudentData(Student student) {
        Random random = new Random();
        NameGenerator.setRandomHumanName(student);
        student.setLuckyFactor(Math.random());
        student.setIq((short) (50 + random.nextInt(150)));
    }

    // Процедура для генерации группы студентов
    public static ArrayList<Student> getGroupOfStudents(Short countOfStudents) {
        ArrayList<Student> groupOfStudents = (
                ArrayList<Student>) Stream.generate(Student::new).limit(countOfStudents).collect(Collectors.toList());
        groupOfStudents.forEach(ExamHelper::setRandomStudentData);
        return groupOfStudents;
    }

}
