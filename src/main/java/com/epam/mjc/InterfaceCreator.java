package com.epam.mjc;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String str : list) {
                if (!str.matches("^[A-Z].*")) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int a= list.size();
            for (int i = 0; i < a; i++) {
                if (list.get(i) % 2 == 0) list.add(list.get(i));
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values
                .stream()
                .filter(
                        a -> a.matches("^[A-Z]\\S*(\\s+\\S+){3,}\\.$")
                )
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();

            for (String value : list) {
                map.put(value, value.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> list3 = new ArrayList<>();
            list3.addAll(list1);
            list3.addAll(list2);

            return list3;
        };
    }
}
