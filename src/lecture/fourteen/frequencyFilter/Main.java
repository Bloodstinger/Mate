package lecture.fourteen.frequencyFilter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .flatMap(x -> Stream.of(x.split("[^a-zA-Zа-яА-Я0-9]+")))
                .filter(t -> !t.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .forEachOrdered(System.out::println);
    }
}
