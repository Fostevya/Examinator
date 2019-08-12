import exam.Exam;
import teacher.EnglishTeacher;
import teacher.MathTeacher;
import utility.ExamHelper;
import utility.NameGenerator;
import trainee.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Examinator {

    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher();
        EnglishTeacher englishTeacher = new EnglishTeacher();
        Random random = new Random();

        //генерация данных о преподавателях
        NameGenerator.setRandomHumanName(mathTeacher);
        NameGenerator.setRandomHumanName(englishTeacher);
        mathTeacher.setRequiredIq((short) (70 + (random.nextInt(130))));
        englishTeacher.setRequiredIq((short) (70 + (random.nextInt(130))));

        //Генерируем группу студентов студентам
        ArrayList<Student> studentsGroup = new ArrayList<>(ExamHelper.getGroupOfStudents(
                (short) (10 + random.nextInt(40))));

        //начинаем экзамены
        Exam mathExam = new Exam(studentsGroup, mathTeacher);
        Exam englishExam = new Exam(studentsGroup, englishTeacher);
        ArrayList<Exam> exams = new ArrayList<>(Arrays.asList(mathExam, englishExam));
        exams.forEach(Exam::start);

    }

}
