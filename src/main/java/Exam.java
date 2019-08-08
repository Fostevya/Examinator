import java.util.ArrayList;

public class Exam {

    private ArrayList<Student> students;
    private Teacher teacher;
    private ArrayList<String> examResults = new ArrayList<>();

    public Exam(ArrayList<Student> studentsList, Teacher disciplineTeacher) {
        this.students = studentsList;
        this.teacher = disciplineTeacher;
    }

    public void start() {
        System.out.println("Экзамен по дисциплине " + teacher.getDiscipline() + " начался...");
        // Тестируем каждого студента из ArrayList'а
        teacher.getTeacherInformation();
        for (Student st : this.students) {
            examResults.add(teacher.testStudent(st));
        }
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
