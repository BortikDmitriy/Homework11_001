import java.util.List;
import java.util.stream.Collectors;

public class Upper {
    public static List<String> toUpperAndSortDescending(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)  // Перетворюємо всі рядки на верхній регістр
                .sorted((s1, s2) -> s2.compareTo(s1))  // Сортуємо за спаданням
                .collect(Collectors.toList());  // Збираємо результати у список
    }

    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "John", "Peter", "Anna", "Mike");
        List<String> result = toUpperAndSortDescending(names);
        result.forEach(System.out::println);
    }

}
