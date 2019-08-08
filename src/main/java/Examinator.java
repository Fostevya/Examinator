import exam.Exam;
import teachers.EnglishTeacher;
import teachers.MathTeacher;
import helpers.NameGenerator;
import trainees.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Examinator {

    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher();
        EnglishTeacher englishTeacher = new EnglishTeacher();
        ArrayList<Student> studentsGroup = new ArrayList<>();
        Random random = new Random();

        //генерация данных о преподавателях
        NameGenerator.setRandomHumanName(mathTeacher);
        NameGenerator.setRandomHumanName(englishTeacher);
        mathTeacher.setRequiredIq((short) (70 + ((short) (Math.random() * 130))));
        englishTeacher.setRequiredIq((short) (70 + ((short) (Math.random() * 130))));

        /*//ручной воод данных о преподавателях
        mathTeacher.setFirstName(ExamHelper.getUserInput(
                "Введите имя преподавателя по дисциплине " + mathTeacher.getDiscipline() + ": "));
        mathTeacher.setSurName(ExamHelper.getUserInput(
                "Введите его отчество: "));
        mathTeacher.setLastName(ExamHelper.getUserInput(
                "Введите его фамилию: "));
        while (mathTeacher.getRequiredIq() < 1) {
            try {
                mathTeacher.setRequiredIq(ExamHelper.getUserInput(
                        "Введите уровень его IQ: "));
            } catch (Exception e) {
                System.out.println("Попробуйте снова.");
            }
        }

        englishTeacher.setFirstName(ExamHelper.getUserInput(
                "Введите имя преподавателя по дисциплине " + englishTeacher.getDiscipline() + ": "));
        englishTeacher.setSurName(ExamHelper.getUserInput(
                "Введите его отчество: "));
        englishTeacher.setLastName(ExamHelper.getUserInput(
                "Введите его фамилию: "));
        while (englishTeacher.getRequiredIq() < 1) {
            try {
                englishTeacher.setRequiredIq(ExamHelper.getUserInput(
                        "Введите уровень его IQ: "));
            } catch (Exception e) {
                System.out.println("Попробуйте снова.");
            }
        }*/

        //Генерируем имена студентам
        for (int i = 0; i < (10 + random.nextInt(40)); i++) {
            studentsGroup.add(new Student());
            NameGenerator.setRandomHumanName(studentsGroup.get(i));
            studentsGroup.get(i).setLuckyFactor(Math.random());
            studentsGroup.get(i).setIq((short) (50 + random.nextInt(150)));
        }

        //начинаем экзамены
        Exam mathExam = new Exam(studentsGroup, mathTeacher);
        Exam englishExam = new Exam(studentsGroup, englishTeacher);
        ArrayList<Exam> exams = new ArrayList<>(Arrays.asList(mathExam, englishExam));
        exams.forEach(Exam::start);

    }

}
