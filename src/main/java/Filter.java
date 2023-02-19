import java.util.*;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        for (Integer i : source) {
            if (i > treshold) {
                logger.log("Элемент " + i + " проходит");
            } else {
                logger.log("Элемент " + i + " не проходит");
            }
        }
        List<Integer>
                result = source.stream()
                .filter(x -> x > treshold)
                .collect(Collectors.toList());
        logger.log("Прошло фильтр " + result.size() + " из " + source.size() + " элементов");
        logger.log("Выводим результат на экран");
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < result.size(); j++) {
            sb.append(result.get(j) + " ");
        }
        System.out.println("Отфильтрованный список: " + sb);
        logger.log("Завершаем программу");
        return result;
    }
}
