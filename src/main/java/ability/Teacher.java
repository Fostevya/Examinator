package ability;

import trainee.Student;

public interface Teacher {

    // Интерфейс предполагает, что классы которые используют его,
    // должны уметь тестировать студентов и возвращать название предмета, который преподает преподаватель
    String testStudent(Student student);

    String getDiscipline();

    String getTeacherInformation();

}
