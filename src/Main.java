import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задача №1........................");
// Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы
// в соответствии порядком, заданным Comparator'ом.
        findMinMax(
                Stream.of(25,11,47,1,3,9,53,12,111,24,77,10),
                //Stream.of(),
                Integer::compareTo,
                (x, y) -> System.out.println("min = " + x + ", max = " + y)
        );

        System.out.println("\n Задача №2........................");
//Реализуйте метод, который принимает на вход Список целых чисел и определяет количество четных
// и выводит их в консоль. Решать именно с применением Stream API.
        List<Integer> numb = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        System.out.println("\nКоличество чётных чисел в списке = " + countEven(numb));

    } // main --------------------------------------------------------------------------

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> lst = stream.sorted(order).collect(Collectors.toList());
        if (!lst.isEmpty()) {
            minMaxConsumer.accept(lst.get(0), lst.get(lst.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
    public static long countEven(List<Integer> numb) {
        return numb.stream()
                .filter(e -> e % 2 == 0)
                .peek(e -> System.out.print(e + " ")).count();
    }

}
