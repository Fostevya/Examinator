package helpers;

import abstraction.AbstractHuman;

public class NameGenerator {

    private static String[] maleFirstNameList = {"Евгений", "Владимир", "Денис", "Константин", "Егор", "Андрей", "Никита", "Олег",
            "Александр", "Дмитрий", "Юрий", "Иван", "Аркадий", "Игорь", "Артём", "Григорий", "Георгий", "Владислав",
            "Вячеслав", "Данил", "Сергей", "Радмир", "Ильгиз"};
    private static String[] maleSurNameList = {"Евгеньевич", "Владимирович", "Денисович", "Константинович", "Егорович",
            "Андреевич", "Никитович", "Олегович", "Александрович", "Дмитриевич", "Юрьевич", "Иванович",
            "Аркадьевич", "Игоревич", "Артёмович", "Григориевич", "Георгиевич", "Владиславович", "Вячеславович",
            "Данилович", "Сергеевич", "Радмирович", "Ильгизович"};
    private static String[] maleLastNameList = {"Петров", "Иванов", "Дмитриев", "Рыбкин", "Кун", "Вольт", "Аркашин", "Сидоров",
            "Макаров", "Спиридонов", "Гуляев", "Юревич", "Колчин", "Овчинников", "Рах", "Цинк", "Дудин", "Дунин",
            "Кульков", "Семечкин", "Амбрусевич", "Савельев", "Денисов"};
    private static String[] femaleFirstNameList = {"Ольга", "Екатерина", "Анастасия", "Елена", "Анна", "Надежда", "Дана",
            "Наталья", "Татьяна", "Ирина", "Эльвира", "Ильмира", "Гузель", "Алина", "Ангелина", "Светлана", "Мария",
            "Валентина", "Полина", "Юлия", "Антонина", "Виктория", "Марина"};
    private static String[] femaleSurNameList = {"Евгеньевна", "Владимировна", "Денисовна", "Константиновна", "Егоровна",
            "Андреевна", "Никитичвна", "Олеговна", "Александровна", "Дмитриевна", "Юрьевна", "Ивановна",
            "Аркадьевна", "Игоревна", "Артёмовна", "Григориевна", "Георгиевна", "Владиславовна", "Вячеславовна",
            "Даниловна", "Сергеевна", "Радмировна", "Ильгизовна"};
    private static String[] femaleLastNameList = {"Иванова", "Куприянова", "Кузьмина", "Аркадьева", "Куликова", "Маринина",
            "Гуляева", "Антропова", "Цинк", "Муляшова", "Крутая", "Макарова", "Норьева", "Морозова", "Леонова",
            "Проводнова", "Хорнова", "Миннабаева", "Ведрова", "Дмитрова", "Антошина", "Егорова", "Катина"};

    // Генерация случайных ФИО для класса AbstractHuman
    public static void setRandomHumanName(AbstractHuman human) {
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

}
