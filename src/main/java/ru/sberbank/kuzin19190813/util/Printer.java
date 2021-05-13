package ru.sberbank.kuzin19190813.util;

import java.util.Collection;

public class Printer {
    public static <C extends Collection<E>, E> void printCollection(C collection) {
        collection.forEach(System.out::println);
    }
}
