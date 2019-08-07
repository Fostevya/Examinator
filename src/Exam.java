import java.util.ArrayList;

public class Exam {

    private ArrayList<Student> students;
    private Teacher teacher;
    private ArrayList<String> examResults = new ArrayList<>();
    private String examDiscipline;

    public Exam(ArrayList<Student> studentsList, Teacher disciplineTeacher) {
        this.students = studentsList;
        this.teacher = disciplineTeacher;
        this.examDiscipline = teacher.getDiscipline();
    }

    public void start() {
        System.out.println("Экзамен по дисциплине " + examDiscipline + " начался...");
        for (Student st : this.students) {
            examResults.add(teacher.testStudent(st));
        }
        System.out.println("Экзамен закончен.");
    }

    public ArrayList<String> getExamResults() {
        return examResults;
    }

    public String getExamDiscipline() {
        return examDiscipline;
    }
}
