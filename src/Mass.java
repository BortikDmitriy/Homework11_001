import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mass {
    public static String sortAndJoinNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))  // Розділяємо кожен рядок на окремі числа
                .map(Integer::parseInt)  // Перетворюємо рядки у числа
                .sorted()  // Сортуємо числа
                .map(String::valueOf)  // Перетворюємо числа назад у рядки
                .collect(Collectors.joining(", "));  // Об'єднуємо у один рядок з комами
    }

    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        String result = sortAndJoinNumbers(array);
        System.out.println(result);  // Виведе: "0, 1, 2, 4, 5"
    }
}
