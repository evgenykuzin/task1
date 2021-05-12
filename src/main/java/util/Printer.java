package util;

import java.util.Collection;
import java.util.stream.Collectors;

public class Printer {
    public static <C extends Collection<T>, T> void printCollection(C collection) {
        collection.forEach(System.out::println);
    }
}
