package funcional;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class ExemploLamba {

    public static void main(String[] args) {
        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };

        List<Integer> bla = new ArrayList<>();
        bla.sort((Integer a, Integer b) -> 1);
        Set<Integer> integers = Set.copyOf(bla);
    }
}
