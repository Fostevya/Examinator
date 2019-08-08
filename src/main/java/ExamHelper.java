import java.io.*;
import java.util.ArrayList;

public class ExamHelper {

    // Процедура для ввода данных с клавиатуры
    public static String getUserInput(String prompt) {
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

    // Процедура для вывода результатов тестирования в файл
    static void examResultsToFile(Exam exam) {
        String textFileExtension = ".txt";
        ArrayList<String> resultsToWrite = exam.getExamResults();
        try (FileWriter writer = new FileWriter(exam.getExamDiscipline() + textFileExtension, false)) {
            writer.write(exam.getExamInfo() + System.lineSeparator());
            for (String result : resultsToWrite) {
                writer.write(result + System.lineSeparator());
            }
            writer.flush();
            System.out.println("Результаты записаны в файл: " + exam.getExamDiscipline() + textFileExtension);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
