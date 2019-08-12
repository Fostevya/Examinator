package abstraction;

import ability.Teacher;
import trainee.Student;

abstract public class AbstractTeacher extends AbstractHuman implements Teacher {

    private short requiredIq;
    private double moodFactor = Math.random();

    private short getRequiredIq() {
        return requiredIq;
    }

    public void setRequiredIq(short requiredIq) {
        this.requiredIq = requiredIq;
    }

    private double getMoodFactor() {
        return this.moodFactor;
    }

    @Override
    public String getTeacherInformation() {
        StringBuilder teacherInformation = new StringBuilder();
        teacherInformation.append("Преподаватель: ")
                .append(this.getName())
                .append(", требуемый для сдачи экзамена IQ=")
                .append(this.getRequiredIq())
                .append(", настроение - ")
                .append(this.getMoodFactor() > 0.5 ? "хорошее." : "плохое.");
        return teacherInformation.toString();
    }

    // Тестируем студента
    public String testStudent(Student student) {
        StringBuilder message = new StringBuilder();
        message.append("Тестируется студент: ")
                .append(student.getName())
                .append(". ");
        System.out.print(message.toString());
        message.delete(0,message.length()-1);
        student.setLuckyFactor(Math.random());
        boolean isTestPassed = ((student.getIq() > this.getRequiredIq()) ||
                ((double) (student.getIq()) / this.getRequiredIq()) > (1 - this.getMoodFactor() * student.getLuckyFactor()));
        message.append("Студент ").
                append(isTestPassed ? "сдал" : "не сдал")
                .append(" экзамен.");
        System.out.println(message);
        message.delete(0,message.length()-1);
        message.append(student.getName())
                .append(" (IQ=")
                .append(student.getIq())
                .append(") - ").
                append(isTestPassed ? "сдал" : "не сдал");
        return (message.toString());
    }

}
