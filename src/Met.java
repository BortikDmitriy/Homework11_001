import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterator;
import java.util.Spliterators;

public class Met {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean turn = true;

            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }

            @Override
            public T next() {
                if (turn) {
                    turn = false;
                    return iterator1.next();
                } else {
                    turn = true;
                    return iterator2.next();
                }
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }

    public static void main(String[] args) {
        Stream<String> first = Stream.of("a", "b", "c", "d");
        Stream<String> second = Stream.of("1", "2", "3");

        Stream<String> result = zip(first, second);
        result.forEach(System.out::println);  // Виведе: a 1 b 2 c 3
    }
}

