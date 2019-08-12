package exam;

import utility.ExamHelper;
import ability.Teacher;
import trainee.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Exam {

    private ArrayList<Student> students;
    private Teacher teacher;
    private ArrayList<String> examResults = new ArrayList<>();

    public Exam(ArrayList<Student> studentsList, Teacher disciplineTeacher) {
        this.students = studentsList;
        this.teacher = disciplineTeacher;
    }

    public void start() {
        StringBuilder message = new StringBuilder();
        message.append("Экзамен по дисциплине ")
                .append(teacher.getDiscipline())
                .append(" начался...")
                .append(System.lineSeparator())
                .append(teacher.getTeacherInformation());
        System.out.println(message);
        // Тестируем каждого студента из ArrayList'а
        teacher.getTeacherInformation();
        examResults = (ArrayList<String>) students.stream().map(teacher::testStudent).collect(Collectors.toList());
        System.out.println("Экзамен закончен.");
        ExamHelper.examResultsToFile(this);
    }

    public ArrayList<String> getExamResults() {
        return examResults;
    }

    public String getExamDiscipline() {
        return teacher.getDiscipline();
    }

    public String getExamInfo() {
        return teacher.getTeacherInformation();
    }
}
