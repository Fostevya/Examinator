import java.io.*;
import java.util.ArrayList;

public class ExamHelper {

    // Процедура для воода данных с клавиатуры
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            do {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                inputLine = is.readLine();
                if (inputLine.length() == 0) System.out.println("Попробуйте снова.");
            } while (inputLine.length() < 2);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    // Генерация случайных ФИО для класса Human
    public void setRandomHumanName(Human human) {
        String[] maleFirstNameList = {"Евгений", "Владимир", "Денис", "Константин", "Егор", "Андрей", "Никита", "Олег",
                "Александр", "Дмитрий", "Юрий", "Иван", "Аркадий", "Игорь", "Артём", "Григорий", "Георгий", "Владислав",
                "Вячеслав", "Данил", "Сергей", "Радмир", "Ильгиз"};
        String[] maleSurNameList = {"Евгеньевич", "Владимирович", "Денисович", "Константинович", "Егорович",
                "Андреевич", "Никитович", "Олегович", "Александрович", "Дмитриевич", "Юрьевич", "Иванович",
                "Аркадьевич", "Игоревич", "Артёмович", "Григориевич", "Георгиевич", "Владиславович", "Вячеславович",
                "Данилович", "Сергеевич", "Радмирович", "Ильгизович"};
        String[] maleLastNameList = {"Петров", "Иванов", "Дмитриев", "Рыбкин", "Кун", "Вольт", "Аркашин", "Сидоров",
                "Макаров", "Спиридонов", "Гуляев", "Юревич", "Колчин", "Овчинников", "Рах", "Цинк", "Дудин", "Дунин",
                "Кульков", "Семечкин", "Амбрусевич", "Савельев", "Денисов"};
        String[] femaleFirstNameList = {"Ольга", "Екатерина", "Анастасия", "Елена", "Анна", "Надежда", "Дана",
                "Наталья", "Татьяна", "Ирина", "Эльвира", "Ильмира", "Гузель", "Алина", "Ангелина", "Светлана", "Мария",
                "Валентина", "Полина", "Юлия", "Антонина", "Виктория", "Марина"};
        String[] femaleSurNameList = {"Евгеньевна", "Владимировна", "Денисовна", "Константиновна", "Егоровна",
                "Андреевна", "Никитичвна", "Олеговна", "Александровна", "Дмитриевна", "Юрьевна", "Ивановна",
                "Аркадьевна", "Игоревна", "Артёмовна", "Григориевна", "Георгиевна", "Владиславовна", "Вячеславовна",
                "Даниловна", "Сергеевна", "Радмировна", "Ильгизовна"};
        String[] femaleLastNameList = {"Иванова", "Куприянова", "Кузьмина", "Аркадьева", "Куликова", "Маринина",
                "Гуляева", "Антропова", "Цинк", "Муляшова", "Крутая", "Макарова", "Норьева", "Морозова", "Леонова",
                "Проводнова", "Хорнова", "Миннабаева", "Ведрова", "Дмитрова", "Антошина", "Егорова", "Катина"};

        if (Math.random() < 0.5) {
            int rand1 = (int) (Math.random() * maleFirstNameList.length);
            int rand2 = (int) (Math.random() * maleSurNameList.length);
            int rand3 = (int) (Math.random() * maleLastNameList.length);
            human.setFirstName(maleFirstNameList[rand1]);
            human.setSurName(maleSurNameList[rand2]);
            human.setLastName(maleLastNameList[rand3]);
        } else {
            int rand1 = (int) (Math.random() * femaleFirstNameList.length);
            int rand2 = (int) (Math.random() * femaleSurNameList.length);
            int rand3 = (int) (Math.random() * femaleLastNameList.length);
            human.setFirstName(femaleFirstNameList[rand1]);
            human.setSurName(femaleSurNameList[rand2]);
            human.setLastName(femaleLastNameList[rand3]);
        }

    }

    // Процедура для вывода результатов тестирования в файл
    public void examResultsToFile (Exam ex, Human teacher){
        ArrayList<String> resultsToWrite = ex.getExamResults();
        try(FileWriter writer = new FileWriter(ex.getExamDiscipline() + ".txt", false))
        {
            writer.write(teacher.getName() + ", IQ=" + teacher.getIq() + ", в " +
                    (teacher.getMoodFactor() < 0.5 ? "плохом" : "хорошем") +
                    " настроении. Дисциплина: " + ex.getExamDiscipline());
            writer.write("\r\n");
            for (String result : resultsToWrite) {
                writer.write(result + "\r\n");
            }
            writer.flush();
            System.out.println("Результаты записаны в файл: " + ex.getExamDiscipline() + ".txt");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}
