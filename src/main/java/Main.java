import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalArgumentException {
        try {
            Logger logger = Logger.getInstance();
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка: ");
            Scanner scanner = new Scanner(System.in);
            int listSize = scanner.nextInt();
            msgError(listSize);
            System.out.println("Введите верхнюю границу для значений: ");
            Scanner scanner1 = new Scanner(System.in);
            int maxValue = scanner1.nextInt();
            msgError(maxValue);
            logger.log("Создаём и наполняем список");
            Random random = new Random();
            List<Integer> list = new ArrayList<>(listSize);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < listSize; i++) {
                list.add(random.nextInt(maxValue));
                stringBuilder.append(list.get(i) + " ");
            }
            String ss = stringBuilder.toString();
            System.out.println("Вот случайный список: " + ss);
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра:  ");
            Scanner scanner2 = new Scanner(System.in);
            int treshold = scanner2.nextInt();
            msgError(treshold);
            Filter filter = new Filter(treshold);
            filter.filterOut(list);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void msgError(int input) {
        if (input <= 0) {
            Logger logger = Logger.getInstance();
            logger.log("Ошибка!");
            throw new IllegalArgumentException("Введено некорректное значение");
        }
    }
}
