import exam.Exam;
import teacher.EnglishTeacher;
import teacher.MathTeacher;
import utility.ExamHelper;
import utility.NameGenerator;
import trainee.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class Examinator {

    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher();
        EnglishTeacher englishTeacher = new EnglishTeacher();

        //генерация данных о преподавателях
        NameGenerator.setRandomHumanName(mathTeacher);
        NameGenerator.setRandomHumanName(englishTeacher);
        mathTeacher.setRequiredIq((short) (70 + ((short) (Math.random() * 130))));
        englishTeacher.setRequiredIq((short) (70 + ((short) (Math.random() * 130))));

        //Генерируем имена студентам
        ArrayList<Student> studentsGroup = new ArrayList<>(ExamHelper.getGroupOfStudents((short) (10 + Math.random() * 40)));

        //начинаем экзамены
        Exam mathExam = new Exam(studentsGroup, mathTeacher);
        Exam englishExam = new Exam(studentsGroup, englishTeacher);
        ArrayList<Exam> exams = new ArrayList<>(Arrays.asList(mathExam, englishExam));
        exams.forEach(Exam::start);

    }

}
