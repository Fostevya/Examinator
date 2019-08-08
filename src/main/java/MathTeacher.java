public class MathTeacher extends Human implements Teacher {

    private String discipline = "Математика";

    public MathTeacher(){
        //Задаем случайное настроение преподавателю при создании экземпляра класса
        this.setMoodFactor(Math.random());
    }

    // Тестируем студента
    public String testStudent(Student student) {
        System.out.print("Тестируется студент: " + student.getName() + ". ");
        student.setLuckyFactor(Math.random());
        boolean isTestPassed = ((student.getIq() > this.getIq()) ||
                ((student.getIq() / this.getIq()) > (1 - this.getMoodFactor() * student.getLuckyFactor())));
        student.setLastExamResultPositive(isTestPassed);
        System.out.println("Студент " + (isTestPassed ? "сдал" : "не сдал") + " экзамен.");
        return (student.getName() + " (IQ=" + student.getIq() + ") - " + (isTestPassed ? "сдал" : "не сдал"));
    }

    public String getDiscipline() {
        return this.discipline;
    }


}