import java.util.ArrayList;

public class Examinator {

    public static void main(String[] args) {
        MathTeacher mathTeacher = new MathTeacher();
        EnglishTeacher englishTeacher = new EnglishTeacher();
        ArrayList<Student> studentsGroup = new ArrayList<>();
        ExamHelper helper = new ExamHelper();

        //генерация данных о преподавателях
        /*helper.setRandomHumanName(mathTeacher);
        helper.setRandomHumanName(englishTeacher);
        mathTeacher.setIq((short) (70 + ((short) (Math.random() * 130))));
        englishTeacher.setIq((short) (70 + ((short) (Math.random() * 130))));*/

        mathTeacher.setMoodFactor(Math.random());
        englishTeacher.setMoodFactor(Math.random());

        //ручной воод данных о преподавателях
        mathTeacher.setFirstName(helper.getUserInput(
                "Введите имя преподавателя по дисциплине " + mathTeacher.getDiscipline() + ": "));
        mathTeacher.setSurName(helper.getUserInput(
                "Введите его отчество: "));
        mathTeacher.setLastName(helper.getUserInput(
                "Введите его фамилию: "));
        while (mathTeacher.getIq() < 1) {
            try {
                mathTeacher.setIq(helper.getUserInput(
                        "Введите уровень его IQ: "));
            } catch (Exception e) {
                System.out.println("Попробуйте снова.");
            }
        }

        englishTeacher.setFirstName(helper.getUserInput(
                "Введите имя преподавателя по дисциплине " + englishTeacher.getDiscipline() + ": "));
        englishTeacher.setSurName(helper.getUserInput(
                "Введите его отчество: "));
        englishTeacher.setLastName(helper.getUserInput(
                "Введите его фамилию: "));
        while (englishTeacher.getIq() < 1) {
            try {
                englishTeacher.setIq(helper.getUserInput(
                        "Введите уровень его IQ: "));
            } catch (Exception e) {
                System.out.println("Попробуйте снова.");
            }
        }

        //Генерируем имена студентам
        for (int i = 0; i < ((int) (Math.random() * 50)); i++) {
            studentsGroup.add(new Student());
            helper.setRandomHumanName(studentsGroup.get(i));
            studentsGroup.get(i).setLuckyFactor(Math.random());
            studentsGroup.get(i).setIq((short) (50 + ((short) (Math.random() * 150))));
        }

        //начинаем экзамен по математике
        Exam mathExam = new Exam(studentsGroup, mathTeacher);
        System.out.println("Преподаватель: " + mathTeacher.getName() + ", IQ=" + mathTeacher.getIq() + ", настроение - "
                + (mathTeacher.getMoodFactor() > 0.5 ? "хорошее." : "плохое."));
        mathExam.start();
        helper.examResultsToFile(mathExam, mathTeacher);

        //начинаем экзамен по английскому языку
        Exam englishExam = new Exam(studentsGroup, englishTeacher);
        System.out.println("Преподаватель: " + englishTeacher.getName() + ", IQ=" + englishTeacher.getIq() +
                ", настроение - " + (englishTeacher.getMoodFactor() > 0.5 ? "хорошее." : "плохое."));
        englishExam.start();
        helper.examResultsToFile(englishExam, englishTeacher);

    }

}
