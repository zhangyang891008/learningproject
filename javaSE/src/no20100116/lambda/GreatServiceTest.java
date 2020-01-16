package no20100116.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GreatServiceTest {

    public static IGreatService<Student> produceStudent = (name) -> new Student(name);

    public static void main(String[] args) {
        String nameStr = "zhangyang,pangpang,mashibing";
        List<Student> collect = Arrays.stream(nameStr.split(",")).map(s->produceStudent.get(s)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
