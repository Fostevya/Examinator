package abstraction;

import interfaces.Teacher;
import trainees.Student;

abstract public class AbstractTeacher extends AbstractHuman implements Teacher {

    private short requiredIq;
    private double moodFactor = Math.random();

    private short getRequiredIq() {
        return requiredIq;
    }

    public void setRequiredIq(short requiredIq) {
        this.requiredIq = requiredIq;
    }

    public void setRequiredIq(String requiredIq) {
        this.requiredIq = Short.parseShort(requiredIq);
    }

    public void setMoodFactor(double moodFactor) {
        this.moodFactor = moodFactor;
    }

    private double getMoodFactor() {
        return this.moodFactor;
    }

    @Override
    public String getTeacherInformation() {
        return ("Преподаватель: " + this.getName() + ", требуемый для сдачи экзамена IQ=" + this.getRequiredIq()
                + ", настроение - " + (this.getMoodFactor() > 0.5 ? "хорошее." : "плохое."));
    }

    // Тестируем студента
    public String testStudent(Student student) {
        System.out.print("Тестируется студент: " + student.getName() + ". ");
        student.setLuckyFactor(Math.random());
        boolean isTestPassed = ((student.getIq() > this.getRequiredIq()) ||
                ((student.getIq() / this.getRequiredIq()) > (1 - this.getMoodFactor() * student.getLuckyFactor())));
        System.out.println("Студент " + (isTestPassed ? "сдал" : "не сдал") + " экзамен.");
        return (student.getName() + " (requiredIq=" + student.getIq() + ") - " + (isTestPassed ? "сдал" : "не сдал"));
    }

}
