package cn.ceus.cback.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        List<String> filtered = strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        filtered.forEach(str->System.out.println(str));

        IntStream.of(1,2,3).forEach(a-> System.out.println(1));
    }
}
