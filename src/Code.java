import java.util.stream.Stream;

public class Code {
    public static Stream<Long> linearCongruentialGenerator(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        long seed = 0; // Ви можете обрати будь-яке початкове значення

        Stream<Long> randomNumbers = linearCongruentialGenerator(seed, a, c, m);

        // Виводимо перші 10 випадкових чисел для прикладу
        randomNumbers.limit(10).forEach(System.out::println);
    }
}
